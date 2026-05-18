package com.vti.backend.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    boolean deleteAccount(int id);


    boolean updateAccount(int id, String email, String username,
                          String fullName, int departmentId,
                          int positionId);

    boolean createAccount(int id, String email, String username,
                          String fullName, int departmentId,
                          int positionId);
}
