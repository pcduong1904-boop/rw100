package com.vti.backend.repository.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements IAccountRepository {

    @Override
    public Map<String, Account> mapByUsername() {
        Map<String, Account> mapByUsername = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                Date createDate = rs.getDate("create_date");

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));
                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                mapByUsername.put(userName, account);
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return mapByUsername;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                Date createDate = rs.getDate("create_date");

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));
                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                accounts.add(account);
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return accounts;
    }

    @Override
    public boolean create(String email, String username, String fullName, int departmentID, int positionID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO account (email, username, full_name, department_id, position_id)\n" +
                    "VALUES (?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, fullName);
            preparedStatement.setInt(4, departmentID);
            preparedStatement.setInt(5, positionID);

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
    public boolean update(int id, String updateName, String email, String username, int departmentId, int positionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update account set full_name = ?, email = ?, username = ?, department_id = ?, position_id = ? " +
                    "where account_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, username);
            preparedStatement.setInt(4, departmentId);
            preparedStatement.setInt(5, positionId);
            preparedStatement.setInt(6, id);

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
            String sql = "delete from account where account_id = ?;";
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
    public Map<String, Account> mapAccountByUsername() {
        Map<String, Account> mapAccountByUsername = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("account_id");
                String email = rs.getString("email");
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                Date createDate = rs.getDate("create_date");

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));
                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                mapAccountByUsername.put(userName, account);
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return mapAccountByUsername;
    }

    @Override
    public boolean checkUsernameExist(String username, Integer id) {
        boolean checkUsernameExist = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from account where username like ? and (account_id != ? or ? is null);";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, id);
            statement.setInt(3, id);

            rs = statement.executeQuery();
            if (rs.next()) {
                checkUsernameExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return checkUsernameExist;
    }

    @Override
    public boolean checkEmailExist(String email) {
        boolean checkEmailExist = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from account where email like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            rs = statement.executeQuery();
            if (rs.next()) {
                checkEmailExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return checkEmailExist;
    }

    @Override
    public boolean checkIdExist(Integer id) {
        boolean checkIdExist = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from account where account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            rs = statement.executeQuery();
            if (rs.next()) {
                checkIdExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return checkIdExist;
    }

    @Override
    public boolean update(int id, String updateName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update account set username = ? where account_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
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
}