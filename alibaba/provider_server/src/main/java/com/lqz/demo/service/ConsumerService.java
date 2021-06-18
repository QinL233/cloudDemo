package com.lqz.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月18日 17:56:00
 */
@Service
public class ConsumerService {

    /**
     * 方法名为topic名称
     * @return
     */
    @Bean
    public Function<Flux<Message<String>>, Mono<Void>> test1() {
        return flux -> flux.map(message -> {
            System.out.println(message.getPayload());
            return message;
        }).then();
    }

    // 第二种方式
    // 注意使用Flux 要调用 subscribe 不然这个方法不会被消费
//    @Bean
//    public Consumer<Flux<Message<String>>> test1() {
//        return flux -> flux.map(message -> {
//            System.out.println(message.getPayload());
//            return message;
//        }).subscribe();
//    }

//    @Bean
//    public Consumer<Message<String>> test1() {
//        return message -> System.out.println(message.getPayload());
//    }
}
