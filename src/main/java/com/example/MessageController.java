package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by emileenmarianayagam on 1/18/17.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List)messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage (String message){
        /*System.out.println("The message is:");
        System.out.println(message);*/
        Message newMessage = new Message(message);
        messages.save(newMessage);
        return "redirect:/";
    }

    /*@RequestMapping(path = "/delete-message/:id", method = RequestMethod.GET)
    public String deleteMessage(int id){
            messages.delete(id);
        return "home";
    }*/

    @RequestMapping(path = "/delete-message/:id", method = RequestMethod.GET)
    public String deleteMessage(int id){
        messages.delete(id);
        return "home";
    }

}
