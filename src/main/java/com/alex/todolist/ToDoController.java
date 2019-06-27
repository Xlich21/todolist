package com.alex.todolist;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller
public class ToDoController {

    @PersistenceContext
    EntityManager entityManager;


    @GetMapping("/index")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("logged");
        return modelAndView;
    }
    @GetMapping("/mytodo")
    public ModelAndView mytodo(){
        ModelAndView modelAndView = new ModelAndView("mytodo");
        modelAndView.addObject("logged");
        return modelAndView;
    }



    }
