import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();
        question8();
        question9();
        question10();
        question11();
        question12();
        question13();
        question14();
        question15();
        question16();
    }
    //question1
    public static void question1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("So tu: 0");
        } else {
            System.out.println("So tu: " + input.split("\\s+").length);
        }
    }
    //question1
    public static void question2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap s1: ");
        String s1 = sc.nextLine();
        System.out.print("Nhap s2: ");
        String s2 = sc.nextLine();
        System.out.println("Ket qua: " + s1.concat(s2));
    }
    //question2
    public static void question3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        if (!name.isEmpty() && !Character.isUpperCase(name.charAt(0))) {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
        System.out.println("Ten: " + name);
    }
    //question3
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ky tu thu " + (i + 1) + " la: " + name.charAt(i));
        }
    }
    //question4
    public static void question5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho: ");
        String ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.println("Ho ten day du: " + ho + " " + ten);
    }
    //question5
    public static void question6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten day du: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        if (parts.length >= 3) {
            System.out.println("Ho la: " + parts[0]);
            System.out.println("Ten dem la: " + parts[1]);
            System.out.println("Ten la: " + parts[parts.length - 1]);
        } else if (parts.length == 2) {
            System.out.println("Ho la: " + parts[0]);
            System.out.println("Ten la: " + parts[1]);
        } else {
            System.out.println("Ten la: " + parts[0]);
        }
    }
    //question6
    public static void question7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        String[] parts = sc.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1).toLowerCase())
                    .append(" ");
        }
        System.out.println("Chuan hoa: " + result.toString().trim());
    }
    //question7
    public static void question8() {
        String[] groups = {"Java Basic", "Python", "Java Web", "Java Spring Boot", "ReactJS", "Java Android"};
        for (String g : groups) {
            if (g.contains("Java")) {
                System.out.println(g);
            }
        }
    }
    //question8
    public static void question9() {
        String[] groups = {"Java Basic", "Java", "Python", "Java", "ReactJS"};
        for (String g : groups) {
            if (g.equals("Java")) {
                System.out.println(g);
            }
        }
    }
    //question9
    public static void question10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi 1: ");
        String s1 = sc.nextLine();
        System.out.print("Nhap chuoi 2: ");
        String s2 = sc.nextLine();
        String reversed = new StringBuilder(s1).reverse().toString();
        System.out.println(reversed.equals(s2) ? "OK" : "KO");
    }
    //question11
    public static void question11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') count++;
        }
        System.out.println("So lan xuat hien 'a': " + count);
    }
    //question12
    public static void question12() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Dao nguoc: " + reversed);
    }
    //question13
    public static void question13() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        if (input == null || input.isEmpty()) {
            System.out.println("false");
            return;
        }
        System.out.println(!input.matches(".*\\d.*") ? "true" : "false");
    }
    //question14
    public static void question14() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        System.out.print("Ky tu can thay: ");
        char oldChar = sc.nextLine().charAt(0);
        System.out.print("Ky tu thay the: ");
        char newChar = sc.nextLine().charAt(0);
        System.out.println("Ket qua: " + input.replace(oldChar, newChar));
    }
    //question15
    public static void question15() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String[] words = sc.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i > 0) result += " ";
        }
        System.out.println("Ket qua: " + result);
    }
    //question16
    public static void question16() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = sc.nextLine();
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        if (n <= 0 || input.length() % n != 0) {
            System.out.println("KO");
        } else {
            for (int i = 0; i < input.length(); i += n) {
                System.out.println(input.substring(i, i + n));
            }
        }
    }
}
