package com.seyidov.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/","index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/about", "/about.html"})
    public String about(){
        return "about";
    }

    @RequestMapping(value = {"/contact", "/contact.html"})
    public String contact(){
        return "contact";
    }

    @RequestMapping(value = {"/joinus", "/joinus.html"})
    public String joinus(){
        return "joinus";
    }

    @RequestMapping(value = {"/review", "/review.html"})
    public String review(){
        return "review";
    }

    @RequestMapping(value = {"/single", "/single.html"})
    public String single(){
        return "single";
    }

    @RequestMapping(value = {"/cabinet", "/cabinet/index"})
    public String cabinet(){
        return "cabinet/index";
    }

    @RequestMapping(value ="/cabinet/blank_page")
    public String blank_page(){
        return "cabinet/blank_page";
    }

    @RequestMapping(value ="/cabinet/charts")
    public String charts(){
        return "cabinet/charts";
    }

    @RequestMapping(value ="/cabinet/codes")
    public String codes(){
        return "cabinet/codes";
    }

    @RequestMapping(value ="/cabinet/compose-mail")
    public String compose_mail(){
        return "cabinet/compose-mail";
    }
}
