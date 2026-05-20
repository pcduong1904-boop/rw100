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
    // lấy ra các cặp username và account tương ứng


    @Override
    public Map<String, Account> mapByUsername() {
        //  key ,  value    key ko được trùng lặp
        Map<String, Account> mapByUsername = new HashMap<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
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
        }
        return mapByUsername;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
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
        }
        return accounts;
    }

    @Override
    public boolean create(String email, String username, String fullName, int departmentID, int positionID) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: tiến hành thêm mới account
            String sql = "INSERT INTO account (email, username, full_name, department_id, position_id)\n" +
                    "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, fullName);
            preparedStatement.setInt(4, departmentID);
            preparedStatement.setInt(5, positionID);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            return  c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean update(int id, String updateName, String email, String username, int departmentId, int positionId) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: tiến hành update account
            String sql = "update account set full_name = ?, email = ?, username = ?, department_id = ?, position_id = ? " +
                    "where account_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, username);
            preparedStatement.setInt(4, departmentId);
            preparedStatement.setInt(5, positionId);
            preparedStatement.setInt(6, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            return  c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: tiến hành xóa account
            String sql = "delete from account where account_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            return  c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public Map<String, Account> mapAccountByUsername() {
        Map<String, Account> mapAccountByUsername = new HashMap<>();
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
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
        }
        return mapAccountByUsername;
    }

    @Override
    public boolean checkExistID(int id) {
        boolean check = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "SELECT * FROM account WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }

            JDBCUtils.closeConnection(connection, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExistUsername(String username, Integer id) {
        boolean check = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "SELECT * FROM account WHERE username = ?";
            if (id != null) {
                sql += " AND account_id != ?";
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username.trim());

            if (id != null) {
                ps.setInt(2, id);
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }

            JDBCUtils.closeConnection(connection, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExistEmail(String email, Integer id) {
        boolean check = false;
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "SELECT * FROM account WHERE email = ?";
            if (id != null) {
                sql += " AND account_id != ?";
            }

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email.trim());

            if (id != null) {
                ps.setInt(2, id);
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }

            JDBCUtils.closeConnection(connection, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}