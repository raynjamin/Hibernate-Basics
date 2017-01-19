package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kelseynewman on 1/18/17.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (Model model) {
        List<Message> messageList = (List)messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/create-message", method = RequestMethod.POST)
    public String createMessage (String message) {
        Message newMessage = new Message(message);
        messages.save(newMessage);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage (String message, int messageId) {
        Message newMessage  = messages.findOne(messageId);
        newMessage.message = message;
        messages.save(newMessage);
        return "redirect:/";
    }
}
