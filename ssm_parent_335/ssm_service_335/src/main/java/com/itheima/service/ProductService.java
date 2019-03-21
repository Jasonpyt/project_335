package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface ProductService {
    /**
     * 查询全部
     * @return
     */
    List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 修改
     * @param product
     */
    void update(Product product);

    /**
     * 根据id删除
     * @param id
     */
    void delById(Integer id);

    /**
     * 删除多个
     * @param ids
     */
    void delMany(Integer[] ids);

    /**
     * 根据分页参数查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageBean<Product> findByPage(Integer pageNum, Integer pageSize);

    public void testFindByPageHelper(Integer pageNum, Integer pageSize);

    /**
     * 分页助手
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize);
}
