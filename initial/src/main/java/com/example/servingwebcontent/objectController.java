package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class objectController {
    private guessGame Game = new guessGame();
    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }

    @RequestMapping("/todo/{id}")
    private ModelAndView getTodo(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/" + id;
        RestTemplate restTemplate = new RestTemplate();

        ToDo toDo = restTemplate.getForObject(uri, ToDo.class);

        ModelAndView modelAndView = new ModelAndView("toDo");
        modelAndView.addObject("toDo", toDo);

        return modelAndView;
    }

    @GetMapping("/guess")
    public String showGame(Model m) {
        m.addAttribute("Prize", Game.getPrize());
        m.addAttribute("Attempts", Game.getAttempts());
        return "guess";
    }

    @PostMapping("/makeGuess")
    public String guessN(@RequestParam("Number") int num, Model m) {
        try {
            Game.makeGuess(num);
        } catch (IllegalArgumentException e) {
            m.addAttribute("Exception", e.getMessage());
        }
        if(!Game.getWin()){
            m.addAttribute("Prize", Game.getPrize());
            m.addAttribute("Attempts", Game.getAttempts());
            return "redirect:/guess";
        } else{
            m.addAttribute("Prize", Game.getPrize());
            return "congratulations";
        }
    }

    @PostMapping("/reset")
    public String reset() {
        Game.reset();
        return "redirect:/guess";
    }
}
