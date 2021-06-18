package com.lqz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月18日 11:54:00
 */
@RestController
@CrossOrigin
@RequestMapping("/mq")
@EnableBinding({ MqController.TestSource.class, MqController.TestSink.class })
public class MqController {

    @Autowired
    private TestSource source;

    @GetMapping("/test")
    public void test(String msg) {
        source.output1().send(MessageBuilder.withPayload(msg).build());
    }

    public interface TestSource {
        @Output("output1")
        MessageChannel output1();
    }

    public interface TestSink {
        @Input("input1")
        SubscribableChannel input1();
    }

        @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

}
