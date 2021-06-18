package com.lqz.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月18日 17:56:00
 */
@Service
public class ConsumerService {

    @Bean
    public Function<Flux<Message<String>>, Mono<Void>> test1() {
        return flux -> flux.map(message -> {
            System.out.println(message.getPayload());
            return message;
        }).then();
    }
}
