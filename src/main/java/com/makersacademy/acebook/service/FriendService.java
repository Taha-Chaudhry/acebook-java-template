package com.makersacademy.acebook.service;

import com.makersacademy.acebook.model.FriendRequests;
import com.makersacademy.acebook.model.Friends;
import com.makersacademy.acebook.repository.FriendRequestsRepository;
import com.makersacademy.acebook.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

    @Autowired
    private FriendRequestsRepository friendRequestsRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    public FriendRequests sendFriendRequest(Long senderId, Long receiverId) {
        if (friendRequestsRepository.findBySenderIdAndReceiverId(senderId, receiverId).isPresent()) {
            throw new IllegalStateException("Friend request already sent");
        }

        FriendRequests friendRequest = new FriendRequests(senderId, receiverId, false);
        return friendRequestsRepository.save(friendRequest);
    }

    public Friends acceptFriendRequest(Long requestId) {
        FriendRequests friendRequest = friendRequestsRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Friend request not found"));

        if (friendRequest.getIsAccepted()) {
            throw new IllegalStateException("Friend request already accepted");
        }

        friendRequest.setIsAccepted(true);
        friendRequestsRepository.save(friendRequest);

        Friends friendship = new Friends(friendRequest.getSenderId(), friendRequest.getReceiverId());
        return friendsRepository.save(friendship);
    }
}
