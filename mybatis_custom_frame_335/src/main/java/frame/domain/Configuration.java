package frame.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装配置文件中的参数
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    /**
     * Map:因为有查找的需求所以使用map集合
     *  第一个泛型参数： 唯一的id：namespace + id
     */
    private Map<String ,Mapper> xmlMap = new HashMap<String, Mapper>();

    public Map<String, Mapper> getXmlMap() {
        return xmlMap;
    }

    public void setXmlMap(Map<String, Mapper> xmlMap) {
        this.xmlMap = xmlMap;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
