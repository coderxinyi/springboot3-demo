package com.guhave.springboot3.core.menshen;

import cn.xdf.arch.menshen.MenShenClient;
import cn.xdf.arch.menshen.common.ChatCompletionResponse;
import cn.xdf.arch.menshen.common.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void test2() {
        String inputMessage = "根据ets官方判分标准，请给TOEFL写作进行判分，结果按照这个json返回 {\n" +
                "\t\"score\":\"分数\",\n" +
                "\t\"suggestion\":\"中文批改意见\",\n" +
                "\t\"content\":\"修改后的文本\"\n" +
                "}" + "内容是：The lecture challanged the fidelnity of the three evidences provided in the passage. " +
                "First, the map may not be sufficent enough to prove that the Portuguese have visited Australia " +
                "themselves, because the painted Astralia on the map has different shape than real Australia's " +
                "geography features. Hence, the lecturer proposed that the map may be drawed due to the second hand " +
                "stories from Asian sailors, and it was the Portuguese who passed the message to the real map makers." +
                " \n" +
                "\n" +
                "Second, the evidence of knowlege of Australian animals is also challenged by the lecturer. Apart " +
                "from their residence in Australia, the marsupials are also native in northern-south America. Since " +
                "Europeans have visited America in 1500s, it may be the real source of the picture  of marsupial " +
                "published in the 1593 book.\n" +
                "\n" +
                "Last, the analysis of the soil is not a strong evidence, as well. Firstly, the soil might move with " +
                "the time, so the soil buring the key may not be the original ones. Moreover, it's unreasonable to " +
                "use the soil to date the key, because the time the key was dropped in not certain, which may not " +
                "establish a confirmed causal relationship between the soil and the key.";
        String inputMessage2 = "请给TOEFL写作进行判分，总分5分，仅给出总分结果即可。内容是：In the reading passage, the topic is about the " +
                "number of critics believe that the government should not own Amtrak, and Amtrak should be sold to a " +
                "privately owned company. In the lecture, the professor totally disagree with the statement.\n" +
                "First, according to the reading, it says that the government loses money on many Amtrak routes. But " +
                "in the listening part the professor says that the rule is to make a profit, under-use. The citizens " +
                "have the rights to speak about the losing money stuff and the goverment need to find ways to solve " +
                "out these problems.\n" +
                "Scond, in the reading the author said that the government ownship of Amtrak is unfair to privately " +
                "owned transportation companies such as airlines. However, in the lecture the professor stated that " +
                "the United States government support all kinds of the ways to solve these troubles, for example like" +
                " weather. The most important part is that these can not exist without the supporting by the " +
                "government.\n" +
                "Lastly, the reading passage says that the critics maintain that if the government wants to support " +
                "national transportation, it should spend its money elsewhere. On the other side, the professor from " +
                "the lecture argues that the government will invest more money on the service of the transportation/";
        Message message = Message.builder().role(Message.Role.USER).content(inputMessage).build();
        ChatCompletionResponse response = client.chatCompletion("gpt-4", Arrays.asList(message));
        response.getMessages().stream().forEach(out -> {
            log.info("GPT回答内容 : {}", out.getContent());
        });
    }
}
