package com.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {
  
  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;
  public static final String topic= "Kafka_Example";
  
  @GetMapping("/publish/{message}")
  public String post(@PathVariable("message") final String message)
  {
    
    kafkaTemplate.send(topic,message);
    
    return "published successfully";
  }

}
