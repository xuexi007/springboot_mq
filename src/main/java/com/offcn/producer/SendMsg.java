package com.offcn.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMsg {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendmsg")
    @ResponseBody
    public String send(){
        jmsMessagingTemplate.convertAndSend("queue-offcn","hello jms!");
        return "send success";
    }

    //发送map
    @RequestMapping("/sendmap")
    @ResponseBody
    public String sendMap(){
        Map map=new HashMap();
        map.put("id","0001");
        map.put("name","张三");
        map.put("age","18");
        jmsMessagingTemplate.convertAndSend("queue-java001",map);

        return "send success";
    }
}
