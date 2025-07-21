package com.friend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.friend.entity.Friend;
import com.friend.service.FriendService;

@RestController
public class FriendRestController {

	@Autowired
	private FriendService friendService;

	@PostMapping("/createFriend")
	public ResponseEntity<String> createFriend(@RequestBody Friend friend) {

		boolean status = friendService.saveFriend(friend);

		if (status) {

			return new ResponseEntity<String>("Data saved.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/friend/{number}")
	public ResponseEntity<List<Object[]>> getDetails(@PathVariable String number) {

		List<Object[]> data = friendService.retriveDetailsBasedOnFriendNumber(number);

		if (data != null) {
			return new ResponseEntity<List<Object[]>>(data, HttpStatus.OK);
		} else
			return new ResponseEntity<List<Object[]>>(HttpStatus.BAD_REQUEST);

	}

}
