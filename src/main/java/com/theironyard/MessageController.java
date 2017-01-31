package com.theironyard;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.resources.Messages;

import java.util.List;

/**
 * Created by graceconnelly on 1/18/17.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String userName, String userMessage) {
        Message message = new Message(userName, userMessage);
        messages.save(message);
        return "redirect:/";
    }
    @RequestMapping(path="/",method = RequestMethod.GET)
    public String home(Model model) {
        List<Messages> messagesList = (List)messages.findAll();
        model.addAttribute("messages",messagesList);
        return "home";
    }
}
