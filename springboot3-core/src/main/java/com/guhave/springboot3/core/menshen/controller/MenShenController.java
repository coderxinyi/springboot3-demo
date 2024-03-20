package com.guhave.springboot3.core.menshen.controller;

import cn.xdf.arch.menshen.MenShenClient;
import cn.xdf.arch.menshen.common.ChatCompletionResponse;
import cn.xdf.arch.menshen.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/19 18:44:00
 */
@RestController
@Slf4j
public class MenShenController {

    private HashMap<Integer,Message> messageMap = new HashMap<>();
    private static final List<Message> messages = new ArrayList<>();
    @Autowired
    MenShenClient menShenClient;

    @GetMapping("/input/msg")
    public String getMessage(@RequestParam String msg, Integer id) {
        Message message = Message.builder().role(Message.Role.USER).content(msg).build();
        messages.add(message);
        messages.stream().forEach(item -> {
            log.info("messages item : {}", item.getContent());
        });
        ChatCompletionResponse response = menShenClient.chatCompletion("gpt-4",messages);
        log.info("response : {}", response);
        response.getMessages().forEach(item -> {
            log.info("item : {}", item.getContent());
        });
        return "ok";
    }
}
