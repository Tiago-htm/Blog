package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

import jakarta.validation.Valid;


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

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){

        return "postForm";
    }

    
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    // chama o valid para validar as obrigações pedidas para criar um post
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";

    } 

    


 }