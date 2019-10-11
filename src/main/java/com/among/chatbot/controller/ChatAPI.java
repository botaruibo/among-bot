package com.among.chatbot.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Rober
 * @version V1.0
 * @Project: among
 * @Package com.among.chatbot.controller
 * @Description: TODO
 * @date Date : 2019年10月10日 19:26
 */
@RestController
@RequestMapping(value = "/", method = RequestMethod.POST, consumes="application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
public class ChatAPI {
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String command(@RequestBody String words){
        Map map = new HashMap<String, String>();
        map.put("words", "我还在积极学习中，对您说的：“" + words +"”还不能理解。请等待阿萌一些时间，很快我就能为你设置私人行程了^-^");
        return JSON.toJSONString(map);
    }
}
