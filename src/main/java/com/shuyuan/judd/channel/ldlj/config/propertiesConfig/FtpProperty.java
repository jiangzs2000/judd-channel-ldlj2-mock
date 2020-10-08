package com.shuyuan.judd.channel.ldlj.config.propertiesConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Sting
 * create 2018/11/25

 **/
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpProperty {
    //ftp服务器地址
    private String host;
    //ftp服务器端口
    private String port;
    //ftp用户名
    private String userName;
    //ftp密码
    private String password;
    //ftp入网地址
    private String netInPath;
    //ftp对账地址
    private String duizhangPath;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNetInPath() {
        return netInPath;
    }

    public void setNetInPath(String netInPath) {
        this.netInPath = netInPath;
    }

    public String getDuizhangPath() {
        return duizhangPath;
    }

    public void setDuizhangPath(String duizhangPath) {
        this.duizhangPath = duizhangPath;
    }
}
