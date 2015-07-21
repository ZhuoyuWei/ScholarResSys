package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dao.ItemDao;
import com.dao.ScholarTweetDao;
import com.dao.ScholarUserDao;
import com.po.Item;
import com.po.ScholarTweet;
import com.po.ScholarUser;
import com.service.InfoService;

public class InfoServiceImpl implements InfoService {

	private ScholarUserDao scholarUserDao;
	private ScholarTweetDao scholarTweetDao;
	private ItemDao itemDao;
	
	public ScholarUserDao getScholarUserDao() {
		return scholarUserDao;
	}
	public void setScholarUserDao(ScholarUserDao scholarUserDao) {
		this.scholarUserDao = scholarUserDao;
	}
	public ScholarTweetDao getScholarTweetDao() {
		return scholarTweetDao;
	}
	public void setScholarTweetDao(ScholarTweetDao scholarTweetDao) {
		this.scholarTweetDao = scholarTweetDao;
	}
	public ItemDao getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	public boolean PublishOneTweet(String userName, Item item, String content) {
		// TODO Auto-generated method stub
		
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		
		ScholarTweet st=new ScholarTweet();
		st.setCreateby(user);
		st.setCreateTime(Calendar.getInstance());
		st.setItem(item);
		st.setContent(content);
		
		boolean flag= scholarTweetDao.saveOneTweet(st);
		
		user.getTweets().add(st);
		scholarUserDao.saveOneUser(user);
		
		return flag;
	}
	@Override
	public List GetFriendsTweet(String userName) {
		// TODO Auto-generated method stub
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		return scholarTweetDao.getFriendsTweetByUser(user);
	}
	@Override
	public List GetFriendsTweet(String userName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List GetUserTweet(String userName) {
		// TODO Auto-generated method stub
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		return scholarTweetDao.getTweetByUser(user);
	}
	@Override
	public List GetUserTweet(String userName, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		return scholarTweetDao.getTweetByUser(user,pageIndex,pageSize);		
	}
	@Override
	public boolean PublishOneSinaTweet(String content) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}
	
	
	

	
	
	
}
