package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface ProductDao {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */
    @Insert("insert into product values(product_seq.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product findById(Integer id);

    /**
     * 更新
     * @param product
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void update(Product product);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from product where id = #{abc}")
    void delById(Integer id);

    /**
     * 查询总条数
     *
     * count(*) 效率较低
     * count(主键)
     * count(1)
     *
     * @return
     */
    @Select("select count(1) from product")
    Integer findTotalCount();

    /**
     * 根据分页参数查询
     * @param startRowNum
     * @param endRowNum
     * @return
     */
    @Select("select * from  (select p.*,rownum rn from product p ) t where t.rn between #{param1} and #{param2}")
    List<Product> findByPage(Integer startRowNum, Integer endRowNum);
}
