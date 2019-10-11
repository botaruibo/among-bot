package com.among.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Rober
 * @version V1.0
 * @Project: among
 * @Package com.among.chatbot.controller
 * @Description: TODO
 * @date Date : 2019年10月10日 19:31
 */
@Controller
public class ChatPage {
    @RequestMapping("/chat")
    public String chat(){
        return "chatPage";
    }
}
