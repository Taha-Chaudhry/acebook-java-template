package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CommentController {

    @Autowired
    CommentRepository repository;

}
