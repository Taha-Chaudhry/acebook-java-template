package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class PostsController {

    @Autowired
    PostRepository repository;

    @GetMapping("/posts")
    public String index(Model model) {
        Iterable<Post> posts = repository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("post", new Post());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public ModelAndView getPost(@PathVariable Long id){

        ModelAndView modelAndView = new ModelAndView("posts/show");
        Optional<Post> tryGetPost = repository.findById(id);

        if (tryGetPost.isEmpty()){
            //Error handle here later
        }
        Post post = tryGetPost.get();
        modelAndView.addObject("post",post);

        return modelAndView;



    }

    @PostMapping("/posts")
    public RedirectView create(@ModelAttribute Post post) {
        repository.save(post);
        return new RedirectView("/posts");
    }

    @DeleteMapping("/posts/{id}")
    public RedirectView delete(@PathVariable Long id) {
        repository.deleteById(id);
        return new RedirectView("/posts");
    }

}
