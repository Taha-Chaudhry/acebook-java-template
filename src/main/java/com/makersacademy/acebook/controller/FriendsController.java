package com.makersacademy.acebook.controller;


import com.makersacademy.acebook.model.FriendRequests;
import com.makersacademy.acebook.model.Friends;
import com.makersacademy.acebook.repository.FriendsRepository;
import com.makersacademy.acebook.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private FriendService friendService;

    @GetMapping("/{userId}")
    public List<Friends> getFriends(@PathVariable Long userId) {
        return friendsRepository.findByUserId1OrUserId2(userId, userId);
    }

    @PostMapping("/send-request")
    public FriendRequests sendFriendRequest(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return friendService.sendFriendRequest(senderId, receiverId);
    }

    @PostMapping("/accept-request")
    public Friends acceptFriendRequest(@RequestParam Long requestId) {
        return friendService.acceptFriendRequest(requestId);
    }
}
