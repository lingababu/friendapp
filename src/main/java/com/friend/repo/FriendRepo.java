package com.friend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.friend.entity.Friend;

public interface FriendRepo extends JpaRepository<Friend, Integer> {
	
	@Query(value =" select f.friendName, f.friendNumber from Friend f where f.phoneNumber= ?1")
	public List<Object[]> findByphoneNumber(String number);

}
