import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise2 {
    public static void main(String[] args) {

        // QUESTION 1
        int a = 5;
        System.out.printf("Số nguyên là: %d\n", a);

        //  QUESTION 2
        int b = 100000000;
        System.out.printf("Số là: %,d\n", b);

        //  QUESTION 3
        double c = 5.567098;
        System.out.printf("Số thực: %.4f\n", c);

        // QUESTION 4
        String name = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.\n", name);

        // QUESTION 5
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");
        System.out.println(now.format(formatter));

        // = QUESTION 6

        Department d1 = new Department(); d1.id = 1; d1.name = "Sale";
        Department d2 = new Department(); d2.id = 2; d2.name = "Marketing";

        Account acc1 = new Account();
        acc1.email = "a@gmail.com";
        acc1.fullName = "Nguyen Van A";
        acc1.department = d1;

        Account acc2 = new Account();
        acc2.email = "b@gmail.com";
        acc2.fullName = "Tran Van B";
        acc2.department = d2;

        Account acc3 = new Account();
        acc3.email = "c@gmail.com";
        acc3.fullName = "Le Thi C";
        acc3.department = null;

        Account[] accounts = {acc1, acc2, acc3};
        System.out.printf("\n%-20s %-20s %-20s\n", "Email", "FullName", "Department");

        for (Account acc : accounts) {
            String depName = (acc.department == null) ? "Chưa có" : acc.department.name;

            System.out.printf("%-20s %-20s %-20s\n",
                    acc.email,
                    acc.fullName,
                    depName);
        }
    }
}
