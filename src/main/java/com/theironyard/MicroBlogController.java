package com.theironyard;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class MicroBlogController {

//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        return DataSourceBuilder
//                .create()
//                .username("")
//                .password("")
//                .url("")
//                .driverClassName("")
//                .build();
//    } // still need to figure out what this all means for heroku


    @Autowired // this field will be populated with the data it needs when i make microblog controller
            // when spring builds controller, will set messages field to a new message repository (an interface).
            // create anonymous class that implements that interface and set my field to this anonymous class object.
            // Dependency injection
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) { // have parameter list contain model
        List<Message> messageList = (List) messages.findAll(); // put into list everything in message repository
        model.addAttribute("messages", messageList); // give list of messages to model
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String message) {
        Message m = new Message(message); // create new message object
        messages.save(m); // save to repository
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.GET)
    public String editMessage(Model model, @PathVariable(value = "id") Integer id) { // here if we don't add @pathvariable,
        // then you would need to take
        //out the action in edit message, because you can't refer to the ID.
        model.addAttribute("messageId", id); // pass into model the id, with name messageId
        return "editMessage";
    }

    @RequestMapping(path = "/edit-message/{id}", method = RequestMethod.POST)
    public String editMessage(@PathVariable(value = "id") Integer id, String message) {
        Message m = messages.findOne(id); //find message with the passed in id
        m.text = message; // set text field to the message passed in
        messages.save(m); // save to repository
        return "redirect:/";
    }


}


