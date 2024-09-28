package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.service.CodeblogService;
import com.spring.codeblog.model.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CodeblogController {

    @Autowired
    CodeblogService  codeblogService;

    @RequestMapping(value = "/posts", method=RequestMethod.GET)

    
    public ModelAndView getPosts() {
        ModelAndView mv  = new ModelAndView("posts");

        List<Post> posts = codeblogService.findAll(); // retorna a lista de post
        mv.addObject("posts", posts); // objeto que referencia os post
        return mv;

    }



 }