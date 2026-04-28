public class Exercise6 {

    public static void main(String[] args) {

        // Question 1
        printEvenNumbers();

        // Question 2
        Account acc1 = new Account();
        acc1.username = "an";
        acc1.fullName = "Nguyen Van A";

        Account acc2 = new Account();
        acc2.username = "binh";
        acc2.fullName = "Tran Van B";

        Account acc3 = new Account();
        acc3.username = "cuong";
        acc3.fullName = "Le Van C";

        Account[] accounts = {acc1, acc2, acc3};

        printAccounts(accounts);

        // Question 3
        printNumbers();
    }

    // Question 1
    public static void printEvenNumbers() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    // Question 2
    public static void printAccounts(Account[] accounts) {
        for (Account acc : accounts) {
            System.out.println(acc.username + " - " + acc.fullName);
        }
    }

    // Question 3
    public static void printNumbers() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }
}