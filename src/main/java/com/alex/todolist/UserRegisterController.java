package com.alex.todolist;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller
public class UserRegisterController {

    @PersistenceContext
    EntityManager entityManager;


    @GetMapping(value = "/register")
    @Transactional
    public ModelAndView register(@RequestParam("firstName") String firstName,
                                 @RequestParam ("lastName") String lastName,
                                 @RequestParam ("email") String email,
                                 @RequestParam ("password") String password) {

        UserRegister userRegister = new UserRegister();
        userRegister.setFirstName(firstName);
        userRegister.setLastName(lastName);
        userRegister.setEmail(email);
        userRegister.setPassword(password);

        entityManager.persist(userRegister);

        return  new ModelAndView("/index");
    }
}
