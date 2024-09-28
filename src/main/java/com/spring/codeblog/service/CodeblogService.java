package com.spring.codeblog.service;

import com.spring.codeblog.model.Post;

import java.util.List;

public interface CodeblogService {

     List<Post>  findAll(); //para retornar uma lista
     Post findById(long id);
     Post save(Post post); // para salvar o post 


}