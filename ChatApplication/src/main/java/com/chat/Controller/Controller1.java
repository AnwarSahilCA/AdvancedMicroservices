package com.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller1")
public class Controller1 {

    @GetMapping("/")
    public String chatPage() {
        return "chat1";
    }
}

@Controller
@RequestMapping("/chat")
public class Controlle {

    @GetMapping("/")
    public String chatPage() {
        return "chat";
    }
}


