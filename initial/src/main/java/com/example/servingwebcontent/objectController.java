package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class objectController {
    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }

    @RequestMapping("/todo/{id}")
    private ModelAndView getTodo(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        RestTemplate restTemplate = new RestTemplate();

        ToDo toDo = restTemplate.getForObject(uri, ToDo.class);
        System.out.println("todo: " + toDo);

        ModelAndView modelAndView = new ModelAndView("toDo");
        modelAndView.addObject("toDo", toDo);

        return modelAndView;
    }
}
