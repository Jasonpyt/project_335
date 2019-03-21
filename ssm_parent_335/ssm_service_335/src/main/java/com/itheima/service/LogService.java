package com.itheima.service;

import com.itheima.domain.Log; /**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface LogService {
    /**
     * 保存日志
     * @param log
     */
    void save(Log log);
}
