package rabbit.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectionUtil;
import utils.Constants;

import static utils.Constants.EXCHANGE_NAME;
import static utils.Constants.EXCHANGE_NAME_DIRECT;

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

        //申明一个交换机，并且指定type为direct
        channel.exchangeDeclare(EXCHANGE_NAME_DIRECT, "direct");

        String message = "删除商品";

        //指定消息的 KEY
        channel.basicPublish(EXCHANGE_NAME_DIRECT, "delete", null, message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
