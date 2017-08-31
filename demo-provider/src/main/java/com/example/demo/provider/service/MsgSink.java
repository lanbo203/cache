package com.example.demo.provider.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by yexin on 2017/8/31.
 */
@EnableBinding(Sink.class)
public class MsgSink {

    @StreamListener(Sink.INPUT)
    public void messageSink(Object payload) {
        System.out.println("Received: " + payload);
    }
}
