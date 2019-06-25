package rabbit.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectionUtil;

import static utils.Constants.EXCHANGE_NAME_DIRECT;
import static utils.Constants.EXCHANGE_NAME_TOPIC;

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
        channel.exchangeDeclare(EXCHANGE_NAME_TOPIC, "topic");

        String message = "主题模式topic  商品";

        //指定消息的 KEY
        channel.basicPublish(EXCHANGE_NAME_TOPIC, "goods.add", null, message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
