package com.vti.backend.repository.impl;

import com.vti.backend.repository.IPostitionRepository;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPostitionRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB

        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs


            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn position_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn position_name
                // chuyển từ positionName tu String -> enum PositionName
                PositionName positionName = PositionName.valueOf(name);
                // chuyển từ enum -> String
//                positionName.name();
                Position po = new Position(id, name);
                positions.add(po);
            }
            JDBCUtils.closeConnection(connection, statement, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public boolean create(String name) {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "insert into position (position_name) values (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);

            int c = statement.executeUpdate();

            JDBCUtils.closeConnection(conn, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "delete from position where position_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int c = statement.executeUpdate();

            JDBCUtils.closeConnection(conn, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, String name) {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "update position set position_name = ? where position_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, id);

            int c = statement.executeUpdate();

            JDBCUtils.closeConnection(conn, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
