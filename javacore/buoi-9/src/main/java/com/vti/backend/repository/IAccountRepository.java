package com.vti.backend.repository;

import com.vti.entity.Account;
import com.vti.entity.Position;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();

    boolean deleteAccount(int id);


    boolean updateAccount(int id, String email, String username,
                          String fullName, int departmentId,
                          int positionId);

    boolean createAccount(String email, String username,
                          String fullName, int departmentId,
                          int positionId);
}
