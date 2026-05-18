package com.vti.frontend;

import com.vti.backend.controller.AccountController;
import com.vti.backend.controller.DepartmentController;
import com.vti.entity.Account;
import com.vti.entity.Department;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    private AccountController accountController = new AccountController();
    public void run(){
        while (true){
            System.out.println("Moi ban chon chuc nang");
            System.out.println("1.xem danh sach ");
            System.out.println("2. them ");
            System.out.println("3 . sua ");
            System.out.println("4. xoa");
            System.out.println("5. Thoat");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":List<Account> accounts = accountController.findAll();
                    this.showAccount(accounts);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return;
                default:
                    System.out.println(" moi ban nhap lai");
            }
        }
    }

    public void insertAccount() throws ClassNotFoundException {
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

        boolean check = accountController.createAccount(email, username, fullName, deptId, posId);
        System.out.println(check ? "Thêm mới thành công!" : "Thêm mới thất bại!");
    }

    public void updateAccount() throws ClassNotFoundException {
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

        boolean check = accountController.updateAccount(id, email, username, fullName, deptId, posId);
        System.out.println(check ? "Sửa thành công!" : "Sửa thất bại!");
    }

    public void deleteAccount() throws ClassNotFoundException {
        System.out.print("Nhập ID account cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = accountController.deleteAccount(id);
        System.out.println(check ? "Xóa thành công!" : "Xóa thất bại!");
    }

    public void showAccount(List<Account> accounts) {
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
