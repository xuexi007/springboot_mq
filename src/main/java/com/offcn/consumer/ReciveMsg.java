package com.offcn.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ReciveMsg {

    @JmsListener(destination = "queue-offcn")
    public void reciveMsg(String msg){
        System.out.println("收到消息:"+msg);
    }

    @JmsListener(destination = "queue-java001")
    public void reciveMap(Map map){
        System.out.println("接收到消息:id:"+map.get("id")+" name:"+map.get("name")+" age:"+map.get("age"));
    }
}
