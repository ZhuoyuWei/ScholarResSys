package com.service.impl;

import java.util.List;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.dao.ScholarUserDao;
import com.po.ScholarUser;
import com.service.FriendService;

public class FriendServiceImpl implements FriendService {
	
	
	private ScholarUserDao scholarUserDao;
	

	public ScholarUserDao getScholarUserDao() {
		return scholarUserDao;
	}
	public void setScholarUserDao(ScholarUserDao scholarUserDao) {
		this.scholarUserDao = scholarUserDao;
	}


	@Override
	public boolean AddOneFriend(String sourceUserName, String targetUserName) {
		// TODO Auto-generated method stub
		
		ScholarUser targetUser=scholarUserDao.getScholarUserByName(targetUserName);
		if(targetUser==null)
			return false;
		ScholarUser sourceUser=scholarUserDao.getScholarUserByName(sourceUserName);
		return scholarUserDao.addOneUserForUser(sourceUser, targetUser);
	}

	@Override
	public boolean GetAndSaveSinaFriends(User user, String token) {
		// TODO Auto-generated method stub
		
		Friendships friendships=new Friendships();
		friendships.setToken(token);
		int cursor=0;
		String[] friendIds=null;
		try {
			friendIds=friendships.getFriendsIdsByUid(user.getId(), 5000, cursor);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(friendIds==null)
			return false;
		return scholarUserDao.addSinaFriends(user, friendIds);
	}

	@Override
	public int ChangeSinaFriendsToScholarFriends(String userName) {
		// TODO Auto-generated method stub
		
		ScholarUser scholarUser=scholarUserDao.getScholarUserByName(userName);
		List friendList=scholarUserDao.getScholarFriendsForSina(scholarUser);
		boolean flag=false;
		if(friendList!=null)
		{
			flag=scholarUserDao.addSeveralFriendsForUser(scholarUser, friendList);
		}
		if(flag)
			return friendList.size();
		else
			return 0;
	}

}
