package com.dao;

import java.util.List;
import java.util.Set;

import com.po.ScholarTweet;
import com.po.ScholarUser;

public interface ScholarTweetDao {
	List getTweetByUser(ScholarUser user);
	List getFriendsTweetByUser(ScholarUser user);
	List getTweetByUser(ScholarUser user,int pageIndex,int pageSize);
	List getFriendsTweetByUser(ScholarUser user,int pageIndex,int pageSize);	
	
	boolean saveOneTweet(ScholarTweet tweet);
}
