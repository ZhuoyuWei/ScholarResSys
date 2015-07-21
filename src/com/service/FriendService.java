package com.service;

import weibo4j.model.User;

public interface FriendService {
	
	boolean AddOneFriend(String sourceUserName,String targetUserName);
	
	boolean GetAndSaveSinaFriends(User user,String token);
	int ChangeSinaFriendsToScholarFriends(String userName);
}
