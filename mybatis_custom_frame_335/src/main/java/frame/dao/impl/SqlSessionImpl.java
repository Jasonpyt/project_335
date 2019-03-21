package frame.dao.impl;

import frame.dao.SqlSession;
import frame.domain.Configuration;
import frame.domain.Mapper;
import frame.utils.Executor;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration cfg;
    private Executor executor;

    /**
     * 通过构造方法传入配置文件的实体类对象
     * @param cfg
     */
    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        executor = new Executor(cfg);
    }


    public List selectList(String mapperId) {
        //根据mapperId获取返回值类型和sql语句
        Mapper mapper = cfg.getXmlMap().get(mapperId);
        String sql = mapper.getSql();
        String resultType = mapper.getResultType();
        return executor.executeQuery(sql,resultType);
    }

    public void close() {
        executor.close();
    }
}
