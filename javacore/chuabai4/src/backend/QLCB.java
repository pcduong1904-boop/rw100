package backend;

import entity.CanBo;
import entity.CongNhan;
import entity.KySu;
import enums.GioiTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {
    public static void qlcb(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            List<CanBo> canBos = new ArrayList<>(); // luu tru thong tin ve chan bo
            System.out.println("Moi Ban Them Chuc Nang");
            System.out.println("1. them moi can bo");
            System.out.println("2. tim kiem theo ho ten");
            System.out.println("3. hien thi thong tin danh sach cac can bo");
            System.out.println("4. nhap vao ten cua can bo va delete can bo ");
            System.out.println("5. thoat khoi chuong trinh");
            String choose = scanner.nextLine();
            switch (choose){
                case "1" :
                    System.out.println("Them Moi Can Bo");
                    System.out.println("Nhap ho ten");
                    String fullName = scanner.nextLine();
                    System.out.println("Nhap tuoi");
                    int age = scanner.nextInt();
                    System.out.println("Nhap dia chi");
                    String diaChi = scanner.nextLine();

                    System.out.println("Nhap gioi tinh : 1.nam  2.nu  3.khac");
                    String gioiTinhChoose = scanner.nextLine();
                    GioiTinh gioiTinh;
                    switch (gioiTinhChoose){
                        case"1" :
                            gioiTinh = GioiTinh.NAM;
                        case"2" :
                            gioiTinh = GioiTinh.NU;
                        default:
                            gioiTinh = GioiTinh.KHAC;

                    }

                    System.out.println("MOI BAN CHON CAN BO");
                    System.out.println("1");
                    System.out.println("2");
                    System.out.println("3");
                    String canBoChoose = scanner.nextLine();
                    switch (canBoChoose){
                        case"1" :
                            System.out.println("Nhap Bac: ");
                            int bac = scanner.nextInt();
                            CanBo congNhan = new CongNhan(age, diaChi, fullName, gioiTinh, bac);

                            canBos.add(congNhan);
                            System.out.println("da tao cong nhan thanh cong ");
                            break;
                        case"2" :
                            System.out.println("nhap nghanh: ");
                            String nghanh = scanner.nextLine();
                            CanBo kySu = new KySu(age, diaChi, fullName, gioiTinh, bac );
                            canBos.add(kySu);
                            System.out.println("da tao ky su thanh cong");
                        default:


                    }

                case "2" :
                    System.out.println("TIM KIEM THEO HO TENO");
                case "3" :
                    System.out.println("HIEN THI THONG TIN DANH SACH CAC CAN BO");
                case "4" :
                    System.out.println(" NHAP VAO TEN CUA CAN BO VA DELETE CAN BO");
                case "5" :
                    System.out.println("THOAT KHOI CHUONG TRINH");
            }
        }
    }
}
