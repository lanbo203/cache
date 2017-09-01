package com.example.demo.msg.service;

import com.example.demo.common.model.TransMsg;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by yexin on 2017/9/1.
 */
@EnableBinding(Sink.class)
public class MsgSink {

    @StreamListener(Sink.INPUT)
    public void process(TransMsg msg) {
//        System.out.println(message.getPayload());
        System.out.println("sink......"+msg);
//        TransMsg msg = (TransMsg) message.getPayload();



//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
    }
}