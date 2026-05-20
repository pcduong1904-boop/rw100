package com.vti.frontend;

import com.vti.backend.controller.PositionController;
import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private PositionController positionController = new PositionController();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        List<Position> positions = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds position");
            System.out.println("2. Thêm mới position");
            System.out.println("3. Xóa position theo id");
            System.out.println("4. Update position theo ID");
            System.out.println("8. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    positions = positionController.findAll();
                    this.showPosition(positions);
                    break;
                case "2":
                    insertPosition();
                    break;
                case "3":
                    deletePosition();
                    break;
                case "4":
                    updatePosition();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position position : positions) {
            System.out.printf("|%5s|%20s|\n", position.getId(), position.getName());
        }
        if (positions.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }

    public void insertPosition() {
        PositionName name;
        while (true) {
            System.out.println("Nhập tên chức vụ: 1.DEV  2.TEST  3.SCRUM_MASTER  4.PM");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    name = PositionName.DEV;
                    break;
                case "2":
                    name = PositionName.TEST;
                    break;
                case "3":
                    name = PositionName.SCRUM_MASTER;
                    break;
                case "4":
                    name = PositionName.PM;
                    break;
                default:
                    System.out.println("Sai định dạng (chỉ 1-4), nhập lại!");
                    continue;
            }

            if (positionController.checkExistNameAndIdNot(name.name(), null)) {
                System.out.println("Position đã tồn tại, nhập lại!");
                continue;
            }
            break;
        }

        boolean check = positionController.create(name);
        System.out.println(check ? "Thêm mới thành công" : "Thêm mới thất bại");
    }

    public void deletePosition() {
        System.out.println("Nhập ID chức vụ muốn xóa: ");
        int id;

        while (true) {
            id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("ID phải > 0, nhập lại:");
                continue;
            }

            if (!positionController.checkExistID(id)) {
                System.out.println("ID không tồn tại, nhập lại:");
                continue;
            }

            break;
        }

        boolean check = positionController.delete(id);
        System.out.println(check ? "Xóa thành công" : "Xóa thất bại");
    }

    public void updatePosition() {
        System.out.println("Nhập ID chức vụ cần sửa: ");
        int id;

        while (true) {
            id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("ID phải > 0, nhập lại:");
                continue;
            }

            if (!positionController.checkExistID(id)) {
                System.out.println("ID không tồn tại, nhập lại:");
                continue;
            }

            break;
        }

        PositionName name;

        while (true) {
            System.out.println("Nhập tên chức vụ: 1.DEV  2.TEST  3.SCRUM_MASTER  4.PM");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    name = PositionName.DEV;
                    break;
                case "2":
                    name = PositionName.TEST;
                    break;
                case "3":
                    name = PositionName.SCRUM_MASTER;
                    break;
                case "4":
                    name = PositionName.PM;
                    break;
                default:
                    System.out.println("Sai định dạng, nhập lại!");
                    continue;
            }

            // check trùng (trừ chính nó)
            if (positionController.checkExistNameAndIdNot(name.name(), id)) {
                System.out.println("Tên đã tồn tại, nhập lại!");
                continue;
            }

            break;
        }

        boolean check = positionController.update(id, name);
        System.out.println(check ? "Update thành công" : "Update thất bại");
    }
}