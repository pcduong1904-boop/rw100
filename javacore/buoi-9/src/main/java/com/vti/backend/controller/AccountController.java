package com.vti.backend.controller;
import com.vti.backend.service.IAccountService;
import com.vti.backend.service.impl.AccountServiceImpl;
import com.vti.entity.Account;
import java.util.List;

public class AccountController {
    private IAccountService accountService = new AccountServiceImpl();

    public boolean createAccount(String email, String username, String fullName, int deptId, int posId) {
        boolean check = accountService.createAccount(id ,fullName ,email , username, positionId, departmentId);
        return check;
    }

    public boolean updateAccount(int id, String email, String username, String fullName, int deptId, int posId) {
        boolean check = accountService.updateAccount( id ,fullName ,email , username, positionId, departmentId);
        return check;
    }

    public boolean deleteAccount(int id) {
        boolean check = accountService.deleteAccount(id);
        return check;
    }

    public List<Account> findAll(){
        //lay ds tu service
        List<Account> accounts = accountService.findAll();
        return accounts;
    }
}
