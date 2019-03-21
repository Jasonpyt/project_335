package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.domain.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;
    @Override
    public void save(Log log) {
        logDao.save(log);
    }
}
