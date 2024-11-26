package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.FriendRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRequestsRepository extends JpaRepository<FriendRequests, Long> {
    List<FriendRequests> findByReceiverIdAndIsAcceptedFalse(Long receiverId);
    
    List<FriendRequests> findBySenderIdAndIsAcceptedFalse(Long senderId);
    
    List<FriendRequests> findBySenderIdOrReceiverIdAndIsAcceptedTrue(Long userId1, Long userId2);

    Optional<FriendRequests> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
