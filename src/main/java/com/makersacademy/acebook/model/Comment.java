package com.makersacademy.acebook.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int user_id;
    private int post_id;

    public Comment(){}

    public Comment (String content, int user_id, int post_id){
        this.content = content;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public String getContent(){ return this.content;}
    public void setContent(String content) { this.content = content;}


}
