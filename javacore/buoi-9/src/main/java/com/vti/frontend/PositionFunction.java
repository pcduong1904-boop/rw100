package com.vti.frontend;
import com.vti.backend.controller.PositionController;
import com.vti.entity.Position;
import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);
    private PositionController positionController = new PositionController();
    public void run() throws ClassNotFoundException {
        while (true){
            System.out.println("1.xem danh sach");
            System.out.println("2.xem");
            System.out.println("3.sua");
            System.out.println("4.xoa");
            System.out.println("5.thoat");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":  List<Position> positions = positionController.findAll();
                    this.showPosition(positions);
                    break;
                case "2":this.createPosition();
                    break;
                case "3":this.update();
                    break;
                case "4":this.delete();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Moi ban nhap lai");

            }
        }

    }

    public void showPosition(List<Position> positions){
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position po : positions) {
            System.out.printf("|%5s|%20s|\n", po.getPositionId(), po.getPositionName());
        }
        if (positions.size()==0){
            System.out.println("khong tim thay");
        }
        System.out.println("+-----+--------------------+");
    }

    public void createPosition()  {
        System.out.println("Moi ban nhap ten:");
        String name = scanner.nextLine();

        boolean check = positionController.create(name);
        if (check){
            System.out.println("them moi thanh cong");
        }else {
            System.out.println("them moi khong thanh cong");
        }
    }
    public void update() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Tên mới: ");
        String name = scanner.nextLine();

        boolean check = positionController.update(id, name);
        System.out.println(check ? "Update thành công" : "Update thất bại");
    }

    public void delete(){
        System.out.print("Nhập tên: ");
        int id = scanner.nextInt();

        boolean check = positionController.delete(id);
        System.out.println(check ? "Xóa thành công" : "Xóa thất bại");
    }

}
