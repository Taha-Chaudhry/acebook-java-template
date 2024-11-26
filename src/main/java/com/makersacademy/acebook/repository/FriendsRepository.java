package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {
    List<Friends> findByUserId1OrUserId2(Long userId1, Long userId2);
}
