package com.friend.service;

import java.util.List;

import com.friend.entity.Friend;

public interface FriendService {
	
	public boolean saveFriend(Friend friend);
	
	public List<Object[]> retriveDetailsBasedOnFriendNumber(String number);

}
