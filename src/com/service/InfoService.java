package com.service;

import java.util.List;

import com.po.Item;
import com.po.ScholarUser;

public interface InfoService {
	boolean PublishOneTweet(String userName,Item item,String content);
	boolean PublishOneSinaTweet(String content);
	List GetFriendsTweet(String userName);
	List GetFriendsTweet(String userName,int pageIndex,int pageSize);	
	List GetUserTweet(String userName);
	List GetUserTweet(String userName,int pageIndex,int pageSize);	
}
