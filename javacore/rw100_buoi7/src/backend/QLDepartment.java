package backend;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public static void showDepartment(String searchName, int searchId) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "pcduong1904";// mk mysql

      /*  try {
            // b1: ket noi den DB
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("ket noi db thanh cong");
            }
            // b2: lay du lieu tu bang Department
            String sql = "select * from Department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);//thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB

            while (rs.next()) { // lặp qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name"); // lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de : departments) {
                System.out.println(de);
            }

        } catch (Exception e) {
            System.out.println("Ket noi db khong thanh cong");
        }*/
// =======================================================
        // b1: ket noi den DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("ket noi db thanh cong");
            }
            // b2: lay du lieu tu bang Department
            String sql = "select * from Department where department_name like ? and department_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);
            statement.setInt(2, searchId);
            ResultSet rs = statement.executeQuery();//thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB

            while (rs.next()) { // lặp qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name"); // lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de : departments) {
                System.out.println(de);
            }

        } catch (Exception e) {
            System.out.println("Ket noi db khong thanh cong");
        }


    }
    public static void showDepartmentHave2Employee() {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "pcduong1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT d.department_id, d.department_name " +
                    "FROM Department d " +
                    "JOIN Account a ON d.department_id = a.department_id " +
                    "GROUP BY d.department_id, d.department_name " +
                    "HAVING COUNT(a.account_id) >= 2";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("=== Phong ban >= 2 nhan vien ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("department_id") + " - " +
                                rs.getString("department_name")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Ket noi db khong thanh cong");
        }
    }
}
