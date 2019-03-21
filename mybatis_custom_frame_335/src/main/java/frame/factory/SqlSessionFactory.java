package frame.factory;

import frame.dao.SqlSession;
import frame.dao.impl.SqlSessionImpl;
import frame.domain.Configuration;
import frame.domain.Mapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 创建sqlSession对象
 * 加载配置文件
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class SqlSessionFactory {
    //核心配置文件的输入流
    private InputStream inputStream;
    public SqlSessionFactory(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public SqlSession openSession(){
        Configuration cfg = new Configuration();
        loadConfiguration(cfg);
        SqlSession sqlSession = new SqlSessionImpl(cfg);
        return sqlSession;
    }


    /**
     * 载入配置文件
     */
    public void loadConfiguration(Configuration cfg){
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            // 读取配置文件，获取文档对象
            doc = reader.read(inputStream);
            //获取根路径
            Element root = doc.getRootElement();
            //获取根节点中所有的子节点（孙子节点......）：//property
            List<Element> list = root.selectNodes("//property");
            for (Element element : list) {
                String nameValue = element.attributeValue("name");
                String valueValue =element.attributeValue("value");
                if("driver".equals(nameValue)){
                    cfg.setDriver(valueValue);
                }
                if("username".equals(nameValue)){
                    cfg.setUsername(valueValue);
                }
                if("url".equals(nameValue)){
                    cfg.setUrl(valueValue);
                }
                if("password".equals(nameValue)){
                    cfg.setPassword(valueValue);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //加载映射文件
        //获取的mappers子节点
        Element mappers = doc.getRootElement().element("mappers");
        //获取所有的mapper节点
        List<Element> mapperList = mappers.elements("com.itheima.dao");
        for (Element element : mapperList) {
            String path = element.attributeValue("resource");
            loadXmlConfiguration(cfg,path);
        }

    }

    /**
     * 载入映射配置文件
     */
    public void loadXmlConfiguration(Configuration cfg,String path){
        SAXReader reader = new SAXReader();
        //获取映射配置的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        try {
            Document doc = reader.read(inputStream);
            //获取根节点
            Element root = doc.getRootElement();
            //获取namespace的值
            String namespace = root.attributeValue("namespace");
            //获取根节点中所有的子节点
            List<Element> elementList = root.elements();
            for (Element element : elementList) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String sql = element.getTextTrim();
                //com.itheima.domain.User.findAll
                Mapper mapper = new Mapper();
                mapper.setResultType(resultType);
                mapper.setSql(sql);
                cfg.getXmlMap().put(namespace +"."+ id, mapper);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
