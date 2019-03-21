package com.itheima.domain;

import java.util.*;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class User {

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String username;
    private Date birthday;

    private List<String> list;
    private String[] array;
    private Set<String> set;

    private Map<String,Object> map;
    private Properties properties;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", array='" + Arrays.toString(array) + '\'' +
                ", list='" + list + '\'' +
                ", set='" + set + '\'' +
                ", map='" + map + '\'' +
                ", properties='" + properties + '\'' +
                '}';
    }
}
