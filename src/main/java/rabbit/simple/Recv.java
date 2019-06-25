package rabbit.simple;

import com.rabbitmq.client.*;
import utils.ConnectionUtil;

import java.io.IOException;

/**
 * Copyright (C)，XX
 * FileName: Recv
 * Author: zl
 * Date: 2019/6/25  16:36
 * Description: 消息接收者
 **/
public class Recv {
    private final static String QUEUE_NAME = "zl_queue";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        DefaultConsumer defaultConsumer  = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String str = new String(body,"utf-8");
                System.out.println(" [x] Received '" + str + "'");
            }
        };

        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);


//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }
    }

}
