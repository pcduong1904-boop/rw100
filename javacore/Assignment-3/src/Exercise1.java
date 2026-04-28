import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        question1();
        question2();
        question3();
        question4();
    }
    //question1
    public static void question1() {
        float salary1 = 5240.5f;
        float salary2 = 10970.055f;
        int rounded1 = Math.round(salary1);
        int rounded2 = Math.round(salary2);
        System.out.println("Salary 1: " + rounded1);
        System.out.println("Salary 2: " + rounded2);
    }
    //question2
    public static void question2() {
        Random random = new Random();
        int number = random.nextInt(100000);
        String result = String.format("%05d", number);
        System.out.println("So ngau nhien 5 chu so: " + result);
    }
    //question3
    public static void question3() {
        Random random = new Random();
        int number = random.nextInt(100000);
        String formatted = String.format("%05d", number);
        String lastTwo = formatted.substring(formatted.length() - 2);
        int lastTwoInt = number % 100;
        System.out.println("So: " + formatted);
        System.out.println("2 so cuoi (String): " + lastTwo);
        System.out.println("2 so cuoi (Modulo): " + lastTwoInt);
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Khong the chia cho 0!");
            return 0;
        }
        return (double) a / b;
    }
    //question4
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        System.out.println("Thuong: " + divide(a, b));
    }
}