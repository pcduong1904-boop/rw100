package com.vti.dto.csv;

public class AccountCsv {
    private String username;
    private String email;

    public AccountCsv(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return username + "," + email;
    }
}
