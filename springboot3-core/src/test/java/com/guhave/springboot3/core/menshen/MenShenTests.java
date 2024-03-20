package com.guhave.springboot3.core.menshen;

import cn.xdf.arch.menshen.MenShenClient;
import cn.xdf.arch.menshen.common.ChatCompletionResponse;
import cn.xdf.arch.menshen.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guxinxin@xdf.cn
 * @createTime 2024/03/20 16:02:00
 */
@SpringBootTest
@Slf4j
class MenShenTests {

    @Autowired
    private MenShenClient client;

    @Test
    void test() {
        Scanner scanner = new Scanner(System.in);
        List<Message> messageList = new ArrayList<>();
        log.info("请输入问题~");
        while (true) {
            String inputMessage = scanner.nextLine();
            Message message = Message.builder().role(Message.Role.USER).content(inputMessage).build();
            messageList.add(message);
            AtomicInteger i = new AtomicInteger(1);
            messageList.stream().forEach(m -> {
                log.info("提问记录,问题 : " + i + " : " + m.getContent());
                i.getAndIncrement();
            });
            ChatCompletionResponse response = client.chatCompletion("gpt-4", messageList);
            response.getMessages().stream().forEach(out -> {
                log.info("GPT回答内容 : {}", out.getContent());
            });
        }
    }
}
