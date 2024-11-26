package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Comment;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.CommentRepository;
import com.makersacademy.acebook.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController{

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/posts/{postId}/comments")
    public String showCommentForm(@PathVariable Long postId, Model model) {
        Post post = postRepository.findById(postId).orElseThrow();
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "comments/new";
    }

    @PostMapping("/posts/{postId}/comments")
    public String addComment(@PathVariable Long postId,
                             @Valid @ModelAttribute Comment comment,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            Iterable<Post> posts = postRepository.findAll();
            model.addAttribute("posts", posts);
            model.addAttribute("error", "Comment content cannot be empty.");
            return "posts/index";
        }

        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);
        commentRepository.save(comment);
        return "redirect:/posts";
    }
}
