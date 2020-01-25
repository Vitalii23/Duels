package com.info.apache.jdbc.service;

import com.info.apache.model.Account;

import java.util.List;

public interface AccountService {

    boolean entry(String name, String password);

    void add(String name, String password);

    void delete(int id);

    List<Account> list();
}
