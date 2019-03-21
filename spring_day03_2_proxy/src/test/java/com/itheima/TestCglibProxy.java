package com.itheima;

import com.itheima.factory.ProductFactory;
import com.itheima.old.dao.SalDao;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 *
 * cglib动态代理
 *      基于子类的动态代理
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestCglibProxy {
    @Test
    public void test(){
        //真实对象
       final SalDao saleDao = new SalDao();
        //创建增强对象: Enhancer:增强
        Enhancer enhancer = new Enhancer();
        //指定代理对象的父类对象
        enhancer.setSuperclass(saleDao.getClass());
        //增强的内容
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 拦截所有的方法
             * @param o   代理对象
             * @param method   被代理的方法
             * @param objects  被代理的方法的参数
             * @param methodProxy  代理方法
             * @return
             * @throws Throwable
             */

            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //工厂生产一个产品，必须卖出去
                ProductFactory productFactory = new ProductFactory();
                //成本价
                Double makePrice = productFactory.make();
                //method :就是销售的方法
                method.invoke(saleDao,objects);
                //判断是否挣钱
                //销售的价格
                Double salePrice = (Double) objects[0];
                if(makePrice > salePrice){
                    System.out.println("赔了"+(makePrice - salePrice)+"钱，不卖");
                }else{
                    System.out.println("可以卖了,赚了"+(salePrice -makePrice)+"钱!!!");
                }
                return null;
            }
        });

        //创建代理对象: 增强之后的对象，应该是真实对象的子类对象
       SalDao dao = (SalDao) enhancer.create();
        dao.sale(2000.);
    }
}
