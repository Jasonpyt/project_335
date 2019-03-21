package frame.dao;

import java.util.List;

/**
 * 自定义框架的入口
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface SqlSession {
    /**
     *  查询得到集合对象
     * @param mapperId  唯一的id
     * @return 执行sql语句,封装的结果
     */
    public List selectList(String mapperId);

    /**
     * 释放资源
     */
    public void close();
}
