package com.vti.dto.context;

import com.vti.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountContext {

    private Map<String, Account> mapByUsername = new HashMap<>();

    public AccountContext(Map<String, Account> stringAccountMap) {
        this.mapByUsername = stringAccountMap;
    }

    public Map<String, Account> getMapByUsername() {
        return mapByUsername;
    }
}