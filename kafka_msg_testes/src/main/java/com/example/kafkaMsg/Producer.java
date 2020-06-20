package com.example.kafkaMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Producer {
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer (KafkaTemplate<String, String> k){
        this.kafkaTemplate = k;
    }
    
    public void enviarMsg(String msg){
        log.info("ENVIANDO MSG= "+ msg);
        kafkaTemplate.send("kafka.teste", msg);
    }

}