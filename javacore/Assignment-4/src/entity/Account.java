package entity;

import java.util.Date;

public class Account {
    private int id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String fullName;
    private Position position;
    private Date createDate;

    // 1
    public Account() {
    }

    // 2
    public Account(int id, String email, String username, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    // 3
    public Account(int id, String email, String username, String firstName, String lastName, Position position) {
        this(id, email, username, firstName, lastName);
        this.position = position;
        this.createDate = new Date();
    }

    // 4
    public Account(int id, String email, String username, String firstName, String lastName, Position position, Date createDate) {
        this(id, email, username, firstName, lastName, position);
        this.createDate = createDate;
    }

    // dùng cho Group
    public Account(String username) {
        this.username = username;
    }

    // getter setter
    public String getFullName() {
        return fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }
}