package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delById(Integer id) {
        productDao.delById(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        //判断数组是否为null
        if(ids != null){
            for (Integer id : ids) {
                productDao.delById(id);
            }
        }
    }

    @Override
    public PageBean<Product> findByPage(Integer pageNum, Integer pageSize) {
        //创PageBean对象
        PageBean<Product> pageBean = new PageBean<>();
        //封装PageBean
        //当前页 -- 页面传参  private Integer pageNum;
        pageBean.setPageNum(pageNum);
        //每页条数 -- 页面传参   private Integer pageSize;
        pageBean.setPageSize(pageSize);
        //总条数 -- 数据库查询  private Integer totalCount;
        Integer totalCount = productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数 -- Math.ceil(totalCount * 1.0 / pageSize )  private Integer totalPage;
        pageBean.setTotalPage((int)Math.ceil(totalCount * 1.0 / pageSize ));
        //当前页数据 -- 数据库查询  private List<T> data;
        /**
         *    起始行号  结束行号  每页三条
         1    1           3
         2    4           6
         3    7           9
         n    pageNum * pageSize - (pageSize - 1)           pageNum * pageSize
         */
        //起始行号
        Integer startRowNum = pageNum * pageSize - (pageSize - 1);
        //结束行号
        Integer endRowNum =  pageNum * pageSize;
        List<Product> productList = productDao.findByPage(startRowNum, endRowNum);
        pageBean.setData(productList);
        return pageBean;
    }

    @Override
    public void testFindByPageHelper(Integer pageNum, Integer pageSize) {
        //设置初始化参数
        PageHelper.startPage(pageNum, pageSize);
        // 查询全部
        List<Product> productList = productDao.findAll();
//      System.out.println(productList.size());

//      PageInfo 相当于自己封装的PageBean,构造方法必须传入查询出来的数据
        PageInfo<Product> pageInfo = new PageInfo(productList,3);
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页条数:"+pageInfo.getPageSize());
        System.out.println("数据:"+pageInfo.getList().size());
        System.out.println("是否第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页:"+pageInfo.isIsLastPage());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("页面上要展示的第一个页码:"+pageInfo.getNavigateFirstPage());
        System.out.println("页面上要展示的最后一个页码:"+pageInfo.getNavigateLastPage());

    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize) {
        //初始化参数
        PageHelper.startPage(pageNum,pageSize);
        //查询全部
        List<Product> productList = productDao.findAll();
        //创建pageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }
}
