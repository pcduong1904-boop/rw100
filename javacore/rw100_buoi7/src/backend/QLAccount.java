package backend;
import entity.Account;
import entity.Department;
import entity.Position;
import utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {

    // Lấy danh sách account
    public static List<Account> findAllAccount() throws ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "SELECT acc.*, de.department_name, po.position_name " +
                    "FROM account acc " +
                    "LEFT JOIN department de ON acc.department_id = de.department_id " +
                    "LEFT JOIN position po ON acc.position_id = po.position_id";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id             = rs.getInt("account_id");
                String email       = rs.getString("email");
                String username    = rs.getString("username");
                String fullName    = rs.getString("full_name");
                int deptId         = rs.getInt("department_id");
                String deptName    = rs.getString("department_name");
                int posId          = rs.getInt("position_id");
                String posName     = rs.getString("position_name");
                Date createDate    = rs.getDate("create_date");

                Department department = new Department(deptId, deptName);
                Position position     = new Position(posId, posName);

                Account account = new Account(id, email, username, fullName, department, position, createDate);
                accounts.add(account);
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Thêm account mới
    public static boolean createAccount(String email, String username,
                                        String fullName, int departmentId,
                                        int positionId) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO account(email, username, full_name, department_id, position_id, create_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, fullName);
            statement.setInt(4, departmentId);
            statement.setInt(5, positionId);
            statement.setDate(6, new Date(System.currentTimeMillis()));
            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sửa account theo ID
    public static boolean updateAccount(int id, String email, String username,
                                        String fullName, int departmentId,
                                        int positionId) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "UPDATE account SET email=?, username=?, full_name=?, " +
                    "department_id=?, position_id=? WHERE account_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, fullName);
            statement.setInt(4, departmentId);
            statement.setInt(5, positionId);
            statement.setInt(6, id);
            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa account theo ID
    public static boolean deleteAccount(int id) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "DELETE FROM account WHERE account_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}