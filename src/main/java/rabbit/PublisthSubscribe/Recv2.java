package rabbit.PublisthSubscribe;

import com.rabbitmq.client.*;
import utils.ConnectionUtil;

import java.io.IOException;

import static utils.Constants.EXCHANGE_NAME;
import static utils.Constants.QUEUE_NAME;
import static utils.Constants.QUEUE_NAME_SMS;

/**
 * Copyright (C)，XX
 * FileName: Recv
 * Author: zl
 * Date: 2019/6/25  17:14
 * Description:
 **/
public class Recv2 {

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME_SMS, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME_SMS, EXCHANGE_NAME, "");


        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        //定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println(" [y] Received '" + message + "'");
                //手动回执
                System.out.println(" 1 结束 ");
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //自动应答改为false
        Boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME_SMS, autoAck, defaultConsumer);
    }

}
