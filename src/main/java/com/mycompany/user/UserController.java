package com.mycompany.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

//import static jdk.internal.org.jline.utils.Colors.s;

@Controller
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers=service.listAll();
        logger.info("List of Books");
        model.addAttribute("listUsers",listUsers);

        return "users";
    }
    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        logger.info("Adding new Bookname");
        model.addAttribute("pageTitle", "Add New Book");

        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user , RedirectAttributes ra){
        service.save(user);
        logger.info("Book has been saved Successfully");
        ra.addFlashAttribute("message", "The book has been saved Successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model , RedirectAttributes ra){
        try {
           User user= service.get(id);
           model.addAttribute("user", user);
            logger.info("Edited the Bookname");
            model.addAttribute("pageTitle", "Edit the Book (ID: " + id +")" );
            return "user_form";
        } catch (UserNotFoundException e) {
            logger.error("Unable to edit the user");
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id , RedirectAttributes ra){
        try {
            service.delete(id);
            logger.info("User has been be deleted");
            ra.addFlashAttribute("message","The user id " + id + "has been be deleted");
        } catch (UserNotFoundException e) {
            logger.error("Got some error");
            ra.addFlashAttribute("message", e.getMessage());

        }
        logger.info("Redirected to the user");
        return "redirect:/users";
    }

}
