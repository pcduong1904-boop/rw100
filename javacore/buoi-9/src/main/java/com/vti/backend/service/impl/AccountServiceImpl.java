package com.vti.backend.service.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.IPositionRepository;
import com.vti.backend.repository.impl.AccountRepositoryImpl;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IAccountService;
import com.vti.dto.ImportError;
import com.vti.dto.context.AccountContext;
import com.vti.dto.csv.AccountCsv;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements IAccountService {
    // khoi tao accountRepository
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private IPositionRepository positionRepository = new PositionRepositoryImpl();


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean create(String email, String username, String fullName, int departmentID, int positionID) {
        return accountRepository.create(email, username, fullName, departmentID, positionID);
    }

    @Override
    public boolean update(int id, String updateName, String email, String username, int departmentId, int positionId) {
        return accountRepository.update(id, updateName, email, username, departmentId, positionId);
    }

    @Override
    public boolean delete(int id) {
        return accountRepository.delete(id);
    }

    @Override
    public Map<String, Account> mapAccountByUsername() {
        return accountRepository.mapAccountByUsername();
    }

    @Override
    public boolean checkUsernameExist(String username, Integer id) {
        return accountRepository.checkUsernameExist(username, id);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return accountRepository.checkEmailExist(email);
    }

    @Override
    public boolean checkIdExist(Integer id) {
        return accountRepository.checkIdExist(id);
    }

    @Override
    public boolean update(int id, String updateName) {
        return accountRepository.update(id, updateName);
    }


    @Override
    public String importAccountFromCSV(String pathName) {

        AccountContext context = new AccountContext(accountRepository.mapAccountByUsername());

        return importFileCSV(pathName, context, "error_account.csv");
    }

    @Override
    public void validation(String line, AccountContext context, List<Account> entities, List<ImportError<AccountCsv>> importErrors) {
        List<String> errors = new ArrayList<>();

        String[] fields = line.split(",");

        String username = fields[0];
        String email = fields[1];

        // validate username
        if (username == null || username.trim().isEmpty()) {
            errors.add("Username không được trống");
        } else if (context.getMapByUsername().get(username) != null) {
            errors.add("Username đã tồn tại");
        }

        // validate email
        if (email == null || email.trim().isEmpty()) {
            errors.add("Email không được trống");
        } else if (!email.contains("@")) {
            errors.add("Email không hợp lệ");
        }

        //
        if (errors.isEmpty()) {
            Account acc = new Account(username, email);
            entities.add(acc);
            context.getMapByUsername().put(username, acc);
        } else {
            AccountCsv csv = new AccountCsv(username, email);
            ImportError<AccountCsv> error = new ImportError<>(csv, errors);
            importErrors.add(error);
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
        for (Account acc : entities) {
            System.out.println("Lưu account: " + acc);
        }
    }

    @Override
    public void exportFileError(List<ImportError<AccountCsv>> errors, String pathError) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathError))) {

            bw.write("username,email,error");
            bw.newLine();

            for (ImportError<AccountCsv> e : errors) {
                String line = e.getCsv().toString() + "," + e.getMessage();
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Đã xuất file lỗi: " + pathError);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}