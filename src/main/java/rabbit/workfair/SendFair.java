package rabbit.workfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectionUtil;
import utils.Constants;

/**
 * Copyright (C)，XX
 * FileName: Send
 * Author: zl
 * Date: 2019/6/25  17:15
 * Description:
 **/
public class SendFair {


    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();


        // 声明队列
        channel.queueDeclare(Constants.QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", Constants.QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }

        channel.close();
        connection.close();
    }

}
