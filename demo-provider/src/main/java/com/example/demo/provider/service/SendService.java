package com.example.demo.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by yexin on 2017/8/31.
 */
@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    public void sendMessage(String msg) {

        try {

            source.output().send(MessageBuilder.withPayload(msg).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
