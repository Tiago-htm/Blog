package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;


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

    @RequestMapping(value = "/posts/{id}", method=RequestMethod.GET)

    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv  = new ModelAndView("postsDetails");
        Post post = codeblogService.findById(id);  //pegar o id 
        mv.addObject("post", post); 
        return mv;

    }



 }