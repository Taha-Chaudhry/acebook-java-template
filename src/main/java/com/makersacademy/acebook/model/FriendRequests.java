package com.makersacademy.acebook.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FRIEND_REQUESTS")
public class FriendRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false)
    private Boolean isAccepted;

    public FriendRequests(Long senderId, Long receiverId, Boolean isAccepted) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isAccepted = isAccepted;
    }
}
