package rabbit.PublisthSubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectionUtil;
import utils.Constants;

import static utils.Constants.EXCHANGE_NAME;

/**
 * Copyright (C)，XX
 * FileName: Send
 * Author: zl
 * Date: 2019/6/25  17:15
 * Description:
 **/
public class Send {


    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();


        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message = "hello world register";

        channel.basicPublish(Constants.EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
