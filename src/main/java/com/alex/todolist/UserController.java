package com.alex.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Controller
public class UserController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;


    @PostMapping("register-action")
    @Transactional
    public ModelAndView register(@RequestParam("name") String name,
                                 @RequestParam ("username") String username,
                                 @RequestParam ("email") String email,
                                 @RequestParam ("password") String password) {

        ModelAndView modelAndView = new ModelAndView("/login");

        User userRegister = new User();
        userRegister.setName(name);
        userRegister.setUsername(username);
        userRegister.setEmail(email);
        userRegister.setPassword(password);

        entityManager.persist(userRegister);


        return modelAndView;

    }

    @GetMapping("register")
    @Transactional
    public ModelAndView registerPage() {

        return new ModelAndView("/register");
    }



    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView logiAction(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", "Eroare");

            return modelAndView;
        }

       if(user.getPassword().equals(password)) {
           ModelAndView modelAndView = new ModelAndView("redirect:/mytodo");
           return modelAndView;
       } else {
           ModelAndView modelAndView = new ModelAndView("login");
           modelAndView.addObject("message", "Eroare. Parola gresita");

           return modelAndView;
       }


    }
}

