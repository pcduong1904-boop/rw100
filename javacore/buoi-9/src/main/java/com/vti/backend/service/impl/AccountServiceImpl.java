package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.impl.AccountRepositoryImpl;
import com.vti.backend.service.IAccountService;
import com.vti.entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountRepository accountRepository  = new AccountRepositoryImpl();
    @Override
    public List<Account> findAll() {
        List<Account> accounts =accountRepository.findAll();
        return accounts;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean check = accountRepository.deleteAccount(id);
        return check;
    }

    @Override
    public boolean updateAccount(int id, String email, String username,
                                 String fullName, int departmentId,
                                 int positionId) {
        boolean check = accountRepository.updateAccount(id ,fullName ,email , username, positionId, departmentId );
        return check;
    }

    @Override
    public boolean createAccount(int id, String email, String username,
                                 String fullName, int departmentId,
                                 int positionId) {
        boolean check = accountRepository.createAccount( id ,fullName ,email , username, positionId, departmentId);
        return check;
    }
}
