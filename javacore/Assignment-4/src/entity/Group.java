package entity;

import java.util.Date;

public class Group {
    private int id;
    private String name;
    private Account creator;
    private Account[] accounts;
    private Date createDate;

    public Group() {
    }

    public Group(String name, Account creator, Account[] accounts, Date createDate) {
        this.name = name;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    public Group(String name, Account creator, String[] usernames, Date createDate) {
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;

        this.accounts = new Account[usernames.length];

        for (int i = 0; i < usernames.length; i++) {
            this.accounts[i] = new Account(usernames[i]);
        }
    }

    public String getName() {
        return name;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
