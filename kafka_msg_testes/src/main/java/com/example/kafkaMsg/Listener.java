package com.example.kafkaMsg;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
public class Listener {

    private AtomicInteger contador = new AtomicInteger();

    @KafkaListener(topics = "kafka.teste")
    public void receberMsg(String msg){
        log.info("MSG RECEBIDA= "+ msg);
        contador.getAndIncrement();
        log.info("TOTAL DE MSGs RECEBIDAS= "+contador.get());
    }

}