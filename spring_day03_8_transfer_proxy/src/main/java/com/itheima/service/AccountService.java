package com.itheima.service;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountService {
    /**
     *      进行转账业务
     * @param fromName  转账人
     * @param toName  收款人
     * @param money  转账金额
     */
    public void transfer(String fromName, String toName, Double money);
}
