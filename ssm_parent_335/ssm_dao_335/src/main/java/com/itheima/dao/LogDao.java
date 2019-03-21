package com.itheima.dao;

import com.itheima.domain.Log;
import org.apache.ibatis.annotations.Insert;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface LogDao {

    /**
     * 保存日志
     * @param log
     */
    @Insert("insert into sys_log values(log_seq.nextval, #{visitTime},#{username},#{ip},#{method})")
    void save(Log log);
}
