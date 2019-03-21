package frame.factory;

import java.io.InputStream;

/**
 * 使用构建者模式创建SqlSessionFactory对象
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(inputStream);
        return sqlSessionFactory;
    }

    public SqlSessionFactory build(String path){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(inputStream);
        return sqlSessionFactory;
    }

    public SqlSessionFactory build(){
        String path = "SqlMapConfig.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(inputStream);
        return sqlSessionFactory;
    }
}
