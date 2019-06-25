package utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Copyright (C)，XX
 * FileName: ConnectionUtil
 * Author: zl
 * Date: 2019/6/25  16:23
 * Description: rabbit 连接工具
 **/
public class ConnectionUtil{

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/vhost_zl");
        factory.setUsername("zl");
        factory.setPassword("zl");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
