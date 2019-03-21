package com.itheima.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 帮助程序员创建对象
 *
 *  1. 解析xml
 *  2. 通过反射创建对象
 *  3. 将创建的对象存储起来-- Map(有查找的需求使用Map集合)
 *
 *  4. 提供一个方法获取对象
 *      public static Object getBean(String id)
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class BeanFactory {

    private static Map<String,Object> map = new HashMap<String, Object>();
    //静态代码块
    static{
        /**
         *  1. 解析xml
         *  2. 通过反射创建对象
         *  3. 将创建的对象存储起来-- Map(有查找的需求使用Map集合)
         */
        try {
            SAXReader reader = new SAXReader();
            //读取文档对象
            FileInputStream inputStream = new FileInputStream("src/main/resources/beans.xml");
            //获取文档对象
            Document doc = reader.read(inputStream);
            //解析文档对象-- 获取根节点
            Element root = doc.getRootElement();
            //获取所有的子节点
            List<Element> beanList = root.elements();
            //遍历子节点
            for (Element bean : beanList) {
                //获取每一个bean标签的id和class属性值
                String idValue = bean.attributeValue("id");
                String classValue = bean.attributeValue("class");
                //通过全类名反射创建对象
                //反射获取字节码
                Class clazz = Class.forName(classValue);
                //反射创建一个对象
                Object obj = clazz.newInstance();
                //将创建对象添加到Map集合中，以idValue为键
                map.put(idValue, obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过程序员提供的id获取一个对象
     * @param id
     * @return
     */
    public static Object getBean(String id){
        return map.get(id);
    }
}
