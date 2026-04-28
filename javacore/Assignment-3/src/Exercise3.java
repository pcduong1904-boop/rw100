public class Exercise3 {
    public static void main(String[] args) {
        question1();
        question2();
        question3();
    }
    //question1
    public static void question1() {
        Integer salary = 5000;
        float salaryFloat = salary.floatValue();
        System.out.printf("Luong: %.2f%n", salaryFloat);
    }
    //question2
    public static void question2() {
        String str = "1234567";
        int number = Integer.parseInt(str);
        System.out.println("So int: " + number);
    }
    //question3
    public static void question3() {
        Integer boxed = Integer.valueOf("1234567");
        int unboxed = boxed;
        System.out.println("Unboxed: " + unboxed);
    }
}