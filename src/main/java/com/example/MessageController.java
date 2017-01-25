package com.example;

import com.example.entities.User;
import com.example.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by emileenmarianayagam on 1/18/17.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @Autowired
    UserRepository users;

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.setName( "Emileen");
            try {
                user.setPassword(PasswordStorage.createHash("emileen"));
            } catch (PasswordStorage.CannotPerformOperationException e) {
                e.printStackTrace();
            }
            users.save(user);
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String name, String password) throws Exception{
        User user = users.findFirstByName(name);
        if(user == null){
            user = new User (name, PasswordStorage.createHash(password));
            users.save(user);
        }else if(!PasswordStorage.verifyPassword(password,user.getPassword())){
            throw new Exception("Incorrect Password");
        }
        session.setAttribute("name",name);
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String user =(String)session.getAttribute("name");
        if (user!=null){
            List<Message> messageList = messages.findByUser(users.findFirstByName(user));
            model.addAttribute("userName",user);
            model.addAttribute("messages", messageList);
        }
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage (HttpSession session,String message){
        String name = (String) session.getAttribute("name");
        User user =users.findFirstByName(name);
        Message newMessage = new Message(message);
        newMessage.setUser(user);
        messages.save(newMessage);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(String message, int messageId){
        Message newMessage = messages.findOne(messageId);
        newMessage.message = message;
        messages.save(newMessage);
        return "redirect:/";
    }
}
