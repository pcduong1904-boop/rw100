package backend;

import entity.Department;
import entity.Position;
import enums.PositionName;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {

    // lấy ds các chuc vu trong DB và in ra
    public static List<Position> showPosition() throws ClassNotFoundException {
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


    public static void findByName(String searchName) throws ClassNotFoundException {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from position where position_name like ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);// truyền giá trị searchName vào ? đầu tiên
            ResultSet rs = statement.executeQuery();
            List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn position_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn position_name
                Position po = new Position(id, name.valueOf(name));
                positions.add(po);
            }
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
            System.out.println("+-----+--------------------+");
            for (Position po : positions) {
                System.out.printf("|%5s|%20s|\n", po.getPositionId(), po.getPositionName());
            }
            System.out.println("+-----+--------------------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 2. Thêm mới
    public static boolean create(String name) throws ClassNotFoundException {
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

    // 3. Xóa
    public static boolean delete(String name) throws ClassNotFoundException {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "delete from position where position_name = ?";
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

    // 4. Update
    public static boolean update(int id, String newName) throws ClassNotFoundException {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "update position set position_name = ? where position_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, newName);
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