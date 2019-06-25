package utils;

/**
 * Copyright (C)，XX
 * FileName: Constants
 * Author: zl
 * Date: 2019/6/25  20:24
 * Description: 自定义
 **/
public class Constants {

    //simple 消息队列的名称
    public final static String QUEUE_NAME = "zl_queue";

    //邮件队列名称
    public final static String QUEUE_NAME_EMAIL = "email_queue";

    //短信队列名称
    public final static String QUEUE_NAME_SMS = "sms_queue";

    //发布订阅模式的交换机名称
    public final static String EXCHANGE_NAME = "zl_exchange";

    //路由交换机的名称
    public final static String EXCHANGE_NAME_DIRECT = "zl_exchange_direct";

    //第一个消费者的队列名
    public final static String QUEUE_NAME_DIRECT_ONE = "zl_queue_direct_one";

    //第二个消费者的队列名
    public final static String QUEUE_NAME_DIRECT_TWO = "zl_queue_direct_two";


    //主题交换机的名称
    public final static String EXCHANGE_NAME_TOPIC = "zl_exchange_topic";

    //第一个消费者的队列名
    public final static String QUEUE_NAME_TOPIC_ONE = "zl_queue_topic_one";

    //第二个消费者的队列名
    public final static String QUEUE_NAME_TOPIC_TWO = "zl_queue_topic_two";

}
