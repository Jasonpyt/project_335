package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    public List<User>findAll();
    public void delById(Integer id);
    public  List<User>findByParam(User user);
    public void delByIds(Integer[] ids);
    public void delByIdsList(List<Integer>ids);
}
