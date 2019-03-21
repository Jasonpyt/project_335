package com.itheima.domain;

public class Account {
    //声明属性变量
    private Integer id;
    private String name;
    private  Double money;

    //生成geteer和setter方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
