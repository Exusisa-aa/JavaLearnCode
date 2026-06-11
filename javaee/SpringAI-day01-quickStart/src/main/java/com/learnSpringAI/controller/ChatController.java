package com.learnSpringAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

//    @PostMapping("/chatByCall")
//    public String chatByCall(String prompt){
//        return chatClient
//                .prompt()
//                .user(prompt)
//                .call()
//                .content();
//    }

//    @PostMapping(value = "/chatByStream", produces = "text/html;charset=utf-8")
//    public Flux<String> chatByStream(String prompt){
//        return chatClient
//                .prompt()
//                .user(prompt)
//                .stream()
//                .content();
//    }

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chatByStream(String prompt, String chatId){
        return chatClient
                .prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }


}
