package com.itheima.dao.impl;

import com.itheima.dao.SalDao;

public class SaleDaoImpl implements SalDao {
    public void sale(Double money) {
        System.out.println("正在以"+money+"元出售");
    }
}
