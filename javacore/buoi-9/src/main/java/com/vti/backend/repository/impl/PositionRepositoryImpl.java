package com.vti.backend.repository.impl;

import com.vti.backend.repository.IPositionRepository;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from position;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                Position po = new Position(id, positionName);
                positions.add(po);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return positions;
    }

    @Override
    public boolean create(PositionName name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into position (position_name) values (?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name.name());

            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean update(int id, PositionName name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update position set position_name = ? where position_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name.name());
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from position where position_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean checkExistID(Integer id) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from position where position_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from position where position_name like ? ";
            if (Objects.nonNull(id)) {
                sql += "and position_id != ? ";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (Objects.nonNull(id)) {
                preparedStatement.setInt(2, id);
            }

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        }
        return check;
    }
}