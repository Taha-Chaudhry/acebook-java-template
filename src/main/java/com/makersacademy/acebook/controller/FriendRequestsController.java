package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.FriendRequests;
import com.makersacademy.acebook.repository.FriendRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend-requests")
public class FriendRequestsController {

    @Autowired
    private FriendRequestsRepository friendRequestsRepository;

    @GetMapping("/received/{userId}")
    public List<FriendRequests> getReceivedRequests(@PathVariable Long userId) {
        return friendRequestsRepository.findByReceiverIdAndIsAcceptedFalse(userId);
    }

    @GetMapping("/sent/{userId}")
    public List<FriendRequests> getSentRequests(@PathVariable Long userId) {
        return friendRequestsRepository.findBySenderIdAndIsAcceptedFalse(userId);
    }
}
