package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by mfahrner on 9/6/16.
 */

@Controller
public class HibernateBasicsController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Message> messageList = (List)messages.findAll();
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messageList", messageList);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String message) {
        Message m = new Message(message);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Integer id) {
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.GET)
    public String home(Model model, Integer id) {
        return "edit";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.POST)
    public String home(@PathVariable(value="id") Integer id, String edit) {
        Message m = messages.findOne(id);
        m.text = edit;
        messages.save(m);
        return "redirect:/";
    }

}
