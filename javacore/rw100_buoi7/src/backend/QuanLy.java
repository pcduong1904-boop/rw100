//package backend;
//import entity.Account;
//import entity.Department;
//import entity.Position;
//
//import java.util.*;
//
//
//public class QuanLy {
//    public static void quanly(){
//        Scanner scanner = new Scanner(System.in);
//
//        List<Department> departments = new ArrayList<>();
//        List<Position> positions = new ArrayList<>();
//        List<Account> accounts = new ArrayList<>();
//
//        int depId = 1, posId = 1, accId = 1;
//
//        while (true){
//            System.out.println("======= MENU =======");
//            System.out.println("1. Them phong ban");
//            System.out.println("2. Them chuc vu");
//            System.out.println("3. Them account");
//            System.out.println("4. Xem phong ban");
//            System.out.println("5. Xem chuc vu");
//            System.out.println("6. Xem account");
//            System.out.println("7. Tim account theo phong ban");
//            System.out.println("8. Tim account theo chuc vu");
//            System.out.println("9. Xoa account theo ten");
//            System.out.println("0. Thoat");
//
//            String choose = scanner.nextLine();
//
//            switch (choose){
//
//                case "1":
//                    System.out.print("Nhap ten phong ban: ");
//                    String depName = scanner.nextLine();
//                    departments.add(new Department(depId++, depName));
//                    System.out.println("Da them!");
//                    break;
//
//                case "2":
//                    System.out.print("Nhap ten chuc vu: ");
//                    String posName = scanner.nextLine();
//                    positions.add(new Position(posId++, posName));
//                    System.out.println("Da them!");
//                    break;
//
//                case "3":
//                    if (departments.isEmpty() || positions.isEmpty()){
//                        System.out.println("Phai tao department & position truoc!");
//                        break;
//                    }
//
//                    System.out.print("Nhap email: ");
//                    String email = scanner.nextLine();
//
//                    System.out.print("Nhap username: ");
//                    String username = scanner.nextLine();
//
//                    System.out.print("Nhap fullName: ");
//                    String fullName = scanner.nextLine();
//
//                    System.out.println("Chon department:");
//                    for (int i = 0; i < departments.size(); i++) {
//                        System.out.println(i + " - " + departments.get(i));
//                    }
//                    int depIndex = Integer.parseInt(scanner.nextLine());
//
//                    System.out.println("Chon position:");
//                    for (int i = 0; i < positions.size(); i++) {
//                        System.out.println(i + " - " + positions.get(i));
//                    }
//                    int posIndex = Integer.parseInt(scanner.nextLine());
//
//                    Account acc = new Account(
//                            accId++,
//                            email,
//                            username,
//                            fullName,
//                            departments.get(depIndex),
//                            positions.get(posIndex),
//                            new Date()
//                    );
//
//                    accounts.add(acc);
//                    System.out.println("Da them account!");
//                    break;
//
//                case "4":
//                    if (departments.isEmpty()){
//                        System.out.println("Danh sach rong");
//                    } else {
//                        for (Department d : departments){
//                            System.out.println(d);
//                        }
//                    }
//                    break;
//
//                case "5":
//                    if (positions.isEmpty()){
//                        System.out.println("Danh sach rong");
//                    } else {
//                        for (Position p : positions){
//                            System.out.println(p);
//                        }
//                    }
//                    break;
//
//                case "6":
//                    if (accounts.isEmpty()){
//                        System.out.println("Danh sach rong");
//                    } else {
//                        for (Account a : accounts){
//                            System.out.println(a);
//                        }
//                    }
//                    break;
//
//                case "7":
//                    System.out.print("Nhap ten phong ban: ");
//                    String searchDep = scanner.nextLine();
//
//                    boolean foundDep = false;
//                    for (Account a : accounts){
//                        if (a.getDepartment().getDepartmentName()
//                                .equalsIgnoreCase(searchDep)){
//                            System.out.println(a);
//                            foundDep = true;
//                        }
//                    }
//
//                    if (!foundDep){
//                        System.out.println("Khong tim thay");
//                    }
//                    break;
//
//                case "8":
//                    System.out.print("Nhap ten chuc vu: ");
//                    String searchPos = scanner.nextLine();
//
//                    boolean foundPos = false;
//                    for (Account a : accounts){
//                        if (a.getPosition().getPositionName()
//                                .equalsIgnoreCase(searchPos)){
//                            System.out.println(a);
//                            foundPos = true;
//                        }
//                    }
//
//                    if (!foundPos){
//                        System.out.println("Khong tim thay");
//                    }
//                    break;
//
//                case "9":
//                    System.out.print("Nhap ten account can xoa: ");
//                    String deleteName = scanner.nextLine();
//
//                    boolean deleted = false;
//
//                    Iterator<Account> iterator = accounts.iterator();
//                    while (iterator.hasNext()){
//                        Account a = iterator.next();
//
//                        if (a.getFullName().equalsIgnoreCase(deleteName)){
//                            iterator.remove();
//                            deleted = true;
//                        }
//                    }
//
//                    if (deleted){
//                        System.out.println("Da xoa!");
//                    } else {
//                        System.out.println("Khong tim thay!");
//                    }
//                    break;
//
//                case "0":
//                    System.out.println("Thoat chuong trinh");
//                    return;
//
//                default:
//                    System.out.println("Nhap sai!");
//            }
//        }
//    }
//}