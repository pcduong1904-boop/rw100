package backend;
import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

import java.util.Date;

public class Exercise1 {

    // Question 1
    public void question1() {
        Department d1 = new Department();
        Department d2 = new Department("Sale");

        System.out.println("d1: " + d1.getName());
        System.out.println("d2: " + d2.getName());
    }

    // Question 2
    public void question2() {
        Position pos = new Position();
        pos.setName("Dev");

        Account a1 = new Account();
        Account a2 = new Account(1, "a@gmail.com", "user1", "Nguyen", "A");
        Account a3 = new Account(2, "b@gmail.com", "user2", "Tran", "B", pos);
        Account a4 = new Account(3, "c@gmail.com", "user3", "Le", "C", pos, new Date());

        System.out.println("FullName: " + a2.getFullName());
        System.out.println("CreateDate: " + a3.getCreateDate());
    }

    // Question 3
    public void question3() {
        Account creator = new Account("creator");

        Account[] accs = {
                new Account("user1"),
                new Account("user2")
        };

        Group g1 = new Group("Group1", creator, accs, new Date());

        String[] usernames = {"u1", "u2", "u3"};
        Group g2 = new Group("Group2", creator, usernames, new Date());

        System.out.println("Group1: " + g1.getName());
        System.out.println("Group2 size: " + g2.getAccounts().length);
    }
}
