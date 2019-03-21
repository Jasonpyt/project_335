package com.itheima.dao;

import com.itheima.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    public List<AccountUser> findAll();
}
