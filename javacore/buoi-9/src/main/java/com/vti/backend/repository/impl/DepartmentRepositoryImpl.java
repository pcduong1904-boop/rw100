package com.vti.backend.repository.impl;

import com.vti.backend.repository.IDepartmentRepository;
import com.vti.entity.Department;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentRepositoryImpl implements IDepartmentRepository {

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from department order by department_id asc;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                Department dep = new Department(id, name);
                departments.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return departments;
    }

    @Override
    public boolean create(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into department (department_name) values (?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

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
    public boolean createListDepartment(List<Department> list) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: tiến hành thêm mới department
            String sql = "insert into department (department_name) values (?);";
            preparedStatement = connection.prepareStatement(sql);
            for (Department department : list) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();// executeBatch chay cau lenh insert nhieu ptu
            return true;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean update(int id, String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update department set department_name = ? where department_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
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
            String sql = "delete from department where department_id = ?;";
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
            String sql = "select * from department where department_id = ?";
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
            String sql = "select * from department where department_name like ? ";
            if (Objects.nonNull(id)) {
                sql += "and department_id != ? ";
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