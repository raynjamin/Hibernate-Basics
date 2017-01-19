package com.theironyard.controllers;

import com.theironyard.entities.Message;
import com.theironyard.interfaces.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HibernateMicroblogController {

    @Autowired
    MessageRepository messages;

    @RequestMapping (path = "/", method = RequestMethod.GET)
    public String home (Model model) {

        List<Message> messageList = (List)messages.findAll();
        model.addAttribute("messages", messageList);

        return "home";
    }

    @RequestMapping (path = "/add-message", method = RequestMethod.POST)
    public String addMessage (String text) {

        Message message = new Message(text);
        messages.save(message);

        return "redirect:/";
    }

    @RequestMapping (path= "/edit-message/{id}", method = RequestMethod.GET)

    public String editMessageForm (Model model, @PathVariable(value = "id") Integer id) {

        model.addAttribute("id", id);

        return "edit";
    }

    @RequestMapping (path= "/edit-message/{id}", method = RequestMethod.POST)
    public String editMessage (@PathVariable(value = "id") Integer id, String edit) {

        Message m = messages.findOne(id);
        m.text = edit;
        messages.save(m);

        return "redirect:/";
    }
}
