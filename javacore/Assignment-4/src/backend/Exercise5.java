package backend;

import entity.CanBo;
import entity.CongNhan;
import entity.KySu;
import entity.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {
    private ArrayList<CanBo> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them moi can bo");
            System.out.println("2. Tim kiem theo ten");
            System.out.println("3. Hien thi danh sach");
            System.out.println("4. Xoa theo ten");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    return;
                default:
                    System.out.println("Nhap sai!");
            }
        }
    }

    // thêm cán bộ
    private void add() {
        System.out.println("Chon loai: 1.CongNhan 2.KySu 3.NhanVien");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Ten: ");
        String name = sc.nextLine();
        System.out.print("Tuoi: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Gioi tinh: ");
        String gender = sc.nextLine();
        System.out.print("Dia chi: ");
        String address = sc.nextLine();

        switch (type) {
            case 1:
                System.out.print("Bac: ");
                int bac = sc.nextInt();
                list.add(new CongNhan(name, age, gender, address, bac));
                break;
            case 2:
                System.out.print("Nganh: ");
                String nganh = sc.nextLine();
                list.add(new KySu(name, age, gender, address, nganh));
                break;
            case 3:
                System.out.print("Cong viec: ");
                String cv = sc.nextLine();
                list.add(new NhanVien(name, age, gender, address, cv));
                break;
            default:
                System.out.println("Sai loai!");
        }
    }

    // tìm
    private void search() {
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        for (CanBo cb : list) {
            if (cb.getName().equalsIgnoreCase(name)) {
                cb.printInfo();
            }
        }
    }

    // hiển thị
    private void showAll() {
        for (CanBo cb : list) {
            cb.printInfo();
            System.out.println("-----");
        }
    }

    // xoá
    private void delete() {
        System.out.print("Nhap ten can xoa: ");
        String name = sc.nextLine();

        list.removeIf(cb -> cb.getName().equalsIgnoreCase(name));
    }
}
