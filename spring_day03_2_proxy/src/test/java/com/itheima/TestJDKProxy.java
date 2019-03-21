package com.itheima;

import com.itheima.dao.SalDao;
import com.itheima.dao.impl.SaleDaoImpl;
import com.itheima.factory.ProductFactory;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    @Test
    public void test(){
        //ProductFactory productFactory = new ProductFactory();
        // productFactory.make();

        final SalDao dao= new SaleDaoImpl();

        /**
         * 参数1:类加载器
         * 参数2：代理对象实现的接口
         * 参数3；实现类InvocationHandler接口的实现类, 功能的增强 -- 匿名内部类
         */

        SalDao salDao = (SalDao)Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //工厂生产一个商品必须卖出去
                ProductFactory productFactory = new ProductFactory();
                Double makePrice = productFactory.make();
                method.invoke(dao, args);
                //判断是否赚钱
                Double salPrice = (Double) args[0];
                if (makePrice > salPrice) {
                    System.out.println("赔了" + (makePrice - salPrice) + "元钱，不卖");

                } else {
                    System.out.println("赚钱了" + (salPrice - makePrice) + "元钱,加油卖");


                }
                return null;
            }
        });
        salDao.sale(1600.);
    }

}
