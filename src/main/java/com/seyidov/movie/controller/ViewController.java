package com.seyidov.movie.controller;

import com.seyidov.movie.model.People;
import com.seyidov.movie.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/cabinet/people/show/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        People people = peopleService.findById(id);
        if (people == null) {
            return "redirect:/";
        }
        model.addAttribute("people", people);
        return "cabinet/people/show";
    }
}
