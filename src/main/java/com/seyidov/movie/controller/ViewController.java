package com.seyidov.movie.controller;

import com.seyidov.movie.model.People;
import com.seyidov.movie.model.User;
import com.seyidov.movie.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value="login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
