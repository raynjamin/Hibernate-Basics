package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MicroBlogController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) { // have parameter list contain model
        List<Message> messageList = (List) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String message) {
        Message m = new Message(message);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.GET)
    public String editMessage(Model model, @PathVariable(value = "id") Integer id) { // here if we don't add @pathvariable,
        // then you would need to take
        //out the action in edit message, because you can't refer to the ID.
        model.addAttribute("messageId", id);
        return "editMessage";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.POST)
    public String editMessage(@PathVariable(value = "id") Integer id, String message) {
        Message m = messages.findOne(id);
        m.text = message;
        messages.save(m);
        return "redirect:/";
    }


}


