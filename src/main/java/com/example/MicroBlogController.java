package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MicroBlogController {

    @Autowired
    private MessageRepository messages;

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String messageText) {
        Message message = new Message(messageText);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }
}
