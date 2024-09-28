package com.spring.codeblog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DumyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    //@PostConstruct comentado para nao gerar mais post iguais a esse
    public void savePost() {
        List<Post> postList = new ArrayList<>();
        
        Post post1 = new Post();
        post1.setAutor("Matheus Lima");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Texto de exemplo para o post sobre Docker...");

        Post post2 = new Post();    
        post2.setAutor("Tiago");
        post2.setData(LocalDate.now());
        post2.setTitulo("Java");
        post2.setTexto("Texto de exemplo para o post sobre Java...");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {
            Post postSaved = codeBlogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
