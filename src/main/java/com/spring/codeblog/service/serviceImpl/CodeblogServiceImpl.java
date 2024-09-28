package com.spring.codeblog.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeblogService;

@Service  // para deixar mais especifico
public class CodeblogServiceImpl  implements CodeblogService  {

    @Autowired 
    CodeBlogRepository codeBlogRepository;

    @Override //  vem como Override por ser de  interface estrangeira
    public List<Post> findAll() {
   
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
   
        return codeBlogRepository.findById(id).get(); //metodos ja estao implementados automaticos no banco
    }

    @Override
    public Post save(Post post) {
   
        return codeBlogRepository.save(post);

    }



}