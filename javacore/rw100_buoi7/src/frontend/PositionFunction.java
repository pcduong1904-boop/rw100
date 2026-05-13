package frontend;

import backend.QLPosition;
import entity.Department;
import entity.Position;

import java.awt.*;
import java.util.List;
import java.util.Scanner;


public class PositionFunction {
        private static  Scanner scanner = new Scanner(System.in);

        public static void run() throws ClassNotFoundException {
            while (true){
                System.out.println("=== moi ban chon chuc nang====");
                System.out.println("1. them moi");
                System.out.println("2. xem danh sach");
                System.out.println("3. sua");
                System.out.println("4. xoa");
                System.out.println("5. Thoat");
                String choice = scanner.nextLine();

                switch (choice){
                    case "1" :
                        createPosition();
                        break;
                    case "2" :
                        List<Position> positions = QLPosition.showPosition();
                        showPosition(positions);
                        break;
                    case "3" :update();
                        break;
                    case "4" :delete();
                        break;
                    case "5" :
                        return;
                    default:
                }
            }


    }




    public static void showPosition(List<Position> positions){
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

    public static void createPosition() throws ClassNotFoundException {
        System.out.println("Moi ban nhap ten:");
        String name = scanner.nextLine();

        boolean check = QLPosition.create(name);
        if (check){
            System.out.println("them moi thanh cong");
        }else {
            System.out.println("them moi khong thanh cong");
        }
    }
    static void update() throws ClassNotFoundException {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Tên mới: ");
        String name = scanner.nextLine();

        boolean check = QLPosition.update(id, name);
        System.out.println(check ? "Update thành công" : "Update thất bại");
    }

    static void delete() throws ClassNotFoundException {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        boolean check = QLPosition.delete(name);
        System.out.println(check ? "Xóa thành công" : "Xóa thất bại");
    }

}
