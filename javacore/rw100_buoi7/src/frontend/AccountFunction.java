package frontend;
import backend.QLAccount;
import entity.Account;
import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Sửa account");
            System.out.println("4. Xóa account");
            System.out.println("5. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Account> accounts = QLAccount.findAllAccount();
                    showAccount(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    updateAccount();
                    break;
                case "4":
                    deleteAccount();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }

    public static void insertAccount() throws ClassNotFoundException {
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập username: ");
        String username = scanner.nextLine();

        System.out.print("Nhập họ tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập ID phòng ban: ");
        int deptId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập ID chức vụ: ");
        int posId = Integer.parseInt(scanner.nextLine());

        boolean check = QLAccount.createAccount(email, username, fullName, deptId, posId);
        System.out.println(check ? "Thêm mới thành công!" : "Thêm mới thất bại!");
    }

    public static void updateAccount() throws ClassNotFoundException {
        System.out.print("Nhập ID account cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập email mới: ");
        String email = scanner.nextLine();

        System.out.print("Nhập username mới: ");
        String username = scanner.nextLine();

        System.out.print("Nhập họ tên mới: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập ID phòng ban mới: ");
        int deptId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập ID chức vụ mới: ");
        int posId = Integer.parseInt(scanner.nextLine());

        boolean check = QLAccount.updateAccount(id, email, username, fullName, deptId, posId);
        System.out.println(check ? "Sửa thành công!" : "Sửa thất bại!");
    }

    public static void deleteAccount() throws ClassNotFoundException {
        System.out.print("Nhập ID account cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = QLAccount.deleteAccount(id);
        System.out.println(check ? "Xóa thành công!" : "Xóa thất bại!");
    }

    public static void showAccount(List<Account> accounts) {
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n",
                "ID", "FullName", "Email", "Username", "Phòng ban", "Chức vụ");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for (Account acc : accounts) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n",
                    acc.getAccountID(),
                    acc.getFullName(),
                    acc.getEmail(),
                    acc.getUsername(),
                    acc.getDepartment() != null ? acc.getDepartment().getName() : "N/A",
                    acc.getPosition() != null ? acc.getPosition().getPositionName() : "N/A");
        }
        if (accounts.size() == 0) {
            System.out.println("Không có dữ liệu!");
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
    }
}