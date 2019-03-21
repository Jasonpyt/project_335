package com.itheima.service;

public interface AccountService {
    //执行转账操作

    /**
     *
     * @param fromName  转账人
     * @param toName  收款人
     * @param money  转账金额
     */
    public void transfer(String fromName,String toName,Double money);
}
