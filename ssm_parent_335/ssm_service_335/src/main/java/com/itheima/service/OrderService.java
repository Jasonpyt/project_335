package com.itheima.service;

import com.itheima.domain.Order;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 查询全部
     * @return
     */
    List<Order> findAll();

    /**
     * 保存订单
     * @param order
     */
    void save(Order order);
}
