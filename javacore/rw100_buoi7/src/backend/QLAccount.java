package backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QLAccount {

    public static void showAllAccount() {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "pcduong1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Account";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("=== Danh sach Account ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("account_id") + " - " +
                                rs.getString("full_name") + " - " +
                                rs.getString("username")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }
    }

    public static void findByFullname(String fullname) {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "pcduong1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Account WHERE full_name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + fullname + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("=== Tim fullname ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("account_id") + " - " +
                                rs.getString("full_name")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }
    }

    public static void findByFullnameAndUsername(String fullname, String usernameInput) {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "pcduong1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Account WHERE full_name LIKE ? AND username LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + fullname + "%");
            ps.setString(2, "%" + usernameInput + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("=== Tim fullname + username ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("account_id") + " - " +
                                rs.getString("full_name") + " - " +
                                rs.getString("username")
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }
    }
}