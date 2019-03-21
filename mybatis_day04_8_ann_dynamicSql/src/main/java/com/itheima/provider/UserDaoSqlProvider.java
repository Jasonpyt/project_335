package com.itheima.provider;

import com.itheima.domain.User;

/**
 * sql语句的提供者
 *
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class UserDaoSqlProvider {

    public String findAll(User user){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from user where 1=1 ");
        if(user.getUname() != null){
            sb.append(" and uname like \"%\"#{uname}\"%\" ");
        }
        if(user.getSex() != null){
            sb.append(" and sex = #{sex} ");
        }
        return sb.toString();
    }
}
