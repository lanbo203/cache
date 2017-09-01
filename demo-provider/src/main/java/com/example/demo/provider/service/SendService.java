package com.example.demo.provider.service;

import com.example.demo.common.model.TransMsg;
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

        try{

            System.out.println("send start msg:"+msg);

            source.output().send(MessageBuilder.withPayload(msg).build());
            System.out.println("send end msg:"+msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(TransMsg msg) {

        try {

            System.out.println("send start msg:"+msg.toString());
            source.output().send(MessageBuilder.withPayload(msg).build());
            System.out.println("send end msg:");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
