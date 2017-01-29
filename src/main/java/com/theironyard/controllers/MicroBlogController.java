package com.theironyard.controllers;

import com.theironyard.entities.Message;
import com.theironyard.entities.User;
import com.theironyard.services.MessageRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MicroBlogController {

    @Autowired
    private MessageRepository messages;

    @Autowired
    private UserRepository users;

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

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName, PasswordStorage.createHash(password));
            users.save(user);
        }
        else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String text) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        Message message = new Message(text, user);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model, String text) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        if (user != null) {
            model.addAttribute("user", user);
        }
        List<Message> messageList = (List) messages.findAll();

        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/edit-messages", method = RequestMethod.POST)
    public String editMessages(String text, int textId) {
        Message message = messages.findOne(textId);

        message.setText(text);
        messages.save(message);

        return "redirect:/";
    }
}
