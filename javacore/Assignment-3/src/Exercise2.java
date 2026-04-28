import java.time.LocalDate;

public class Exercise2 {

    static class Account {
        String email;
        String username;
        String fullName;
        LocalDate createDate;
    }

    public static void main(String[] args) {
        question1();
    }
    //question1
    public static void question1() {
        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].email = "Email " + (i + 1);
            accounts[i].username = "User name " + (i + 1);
            accounts[i].fullName = "Full name " + (i + 1);
            accounts[i].createDate = LocalDate.now();
        }
        for (Account acc : accounts) {
            System.out.println(acc.email + " - " + acc.username + " - " + acc.fullName + " - " + acc.createDate);
        }
    }
}