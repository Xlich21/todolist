package com.alex.todolist;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;


@Controller
public class ToDoController {


    @Autowired
    private TodoListRepository todoListRepository;

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

        List<ToDoList> toDoListList = todoListRepository.findAll();
        modelAndView.addObject("todos", toDoListList);

        return modelAndView;
    }

    @PostMapping("/saveTodo")
    public ModelAndView saveTodo(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("category") String category,
                                 @RequestParam("expirationDate") String expirationDate
    ) {

        ModelAndView modelAndView = new ModelAndView("mytodo");
        ToDoList toDoList = new ToDoList();
        toDoList.setName(name);
        toDoList.setDescription(description);
        toDoList.setCategory(category);
        toDoList.setAddingDate(LocalDate.now());
        toDoList.setExpirationDate(expirationDate);
        todoListRepository.save(toDoList);


        List<ToDoList> toDoListList = todoListRepository.findAll();
        modelAndView.addObject("todos", toDoListList);
        return modelAndView;


    }

    @PostMapping("/deleteTodo")
    public ModelAndView saveTodo(@RequestParam("id") Integer id
    ) {

        todoListRepository.deleteById(id);

        ModelAndView modelAndView = new ModelAndView("mytodo");
        List<ToDoList> toDoListList = todoListRepository.findAll();
        modelAndView.addObject("todos", toDoListList);
        return modelAndView;


    }



    }
