package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model)
    {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String,Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        //RequestParam - выдергивает параметры либо с формы, либо с полей ввода
        Message message = new Message(text,tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            System.out.println("filter != null && !filter.isEmpty()");
            messages = messageRepo.findByTag(filter);
        } else {
            System.out.println("else filter");
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);
        return "main";
    }

}