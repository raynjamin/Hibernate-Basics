package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
public class MicroblogSpringController {
    @Autowired
    MessageRepository messages;

    @Autowired
    UserRepository users;

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.setName("Zach");
            try {
                user.setPassword(PasswordStorage.createHash("hunter2"));
            } catch (PasswordStorage.CannotPerformOperationException e) {
                e.printStackTrace();
            }
            users.save(user);
        }
    }

    @RequestMapping(path ="/", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(path ="/add-user", method = RequestMethod.GET)
    public String addUser(String name) {
        User currentUser = new User(name);
        users.save(currentUser);
        return "redirect:/home";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        ArrayList<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String message) {
        Message currentMessage = new Message(message);
        messages.save(currentMessage);
        return "redirect:/";
    }

//    @RequestMapping(path = "/edit-message", method = RequestMethod.GET)
//    public String edit(Model model) {
//        ArrayList<Message> messageList = (ArrayList) messages.findAll();
//        model.addAttribute()
//      return "edit";
//    }
}
