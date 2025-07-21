package com.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.entity.Friend;
import com.friend.repo.FriendRepo;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepo friendRepo;

	@Override
	public boolean saveFriend(Friend friend) {

		Friend savedFriend = friendRepo.save(friend);

		return savedFriend.getId() != null;
	}

	@Override
	public List<Object[]> retriveDetailsBasedOnFriendNumber(String number) {

		List<Object[]> details = friendRepo.findByphoneNumber(number);

		if (details.isEmpty()) {
			return null;
		}

		return details;
	}

}
