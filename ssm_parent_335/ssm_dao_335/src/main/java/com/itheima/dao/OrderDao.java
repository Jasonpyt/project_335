package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface OrderDao {
    /**
     * 查询全部订单
     * @return
     */
    @Select("select * from orders")
    /**
     * @Results:映射结果集，映射多列
     * @Result： 映射一列
     *  column ：映射的列名
     *  property:映射的属性名
     *  javaType:属性的类型
     *  one :映射一个对象
     *  select : mapperId=namespace + id == 接口的全名称 + 方法名称
     */
    @Results({
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.itheima.dao.ProductDao.findById",fetchType = FetchType.LAZY))
    })
    List<Order> findAll();

    /**
     * 保存订单
     * @param order
     *
     * SelectKey: 查询主键
     *  keyColumn:主键列名
     *  keyProperty: 主键属性名
     *  before: 在执行insert之前获取主键还是insert之后获取主键
     *      mysql 需要在insert语句之后获取
     *      oracle需要在insert语句之前获取
     *  resultType:返回值类型
     *  statement: 要执行的sql语句
     *      mysql : select last_insert_id();
     *      oracle: select 序列.nextval from dual;
     *
     */
    @SelectKey(keyColumn ="id",keyProperty = "id",before = true,resultType =Long.class ,statement = "select order_seq.nextval from dual")
    @Insert("insert into orders values(#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc}, #{payType}, #{orderStatus}, #{product.id})")
    void save(Order order);
}
