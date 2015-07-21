package com.service.impl;

import java.util.List;

import weibo4j.Friendships;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.dao.ScholarUserDao;
import com.po.ScholarUser;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService{

	private ScholarUserDao scholarUserDao;



	public ScholarUserDao getScholarUserDao() {
		return scholarUserDao;
	}

	public void setScholarUserDao(ScholarUserDao scholarUserDao) {
		this.scholarUserDao = scholarUserDao;
	}


	@Override
	public boolean CheckUserNameAvailable(String userName) {
		// TODO Auto-generated method stub
		return scholarUserDao.getScholarUserByName(userName)!=null;
	}
	
	@Override
	public ScholarUser GetScholarUserByName(String userName) {
		// TODO Auto-generated method stub
		return scholarUserDao.getScholarUserByName(userName);
	}

	@Override
	public boolean CheckUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return scholarUserDao.getScholarUserByNameAndPassword(userName,password)!=null;
	}

	@Override
	public boolean CheckEmail(String email) {
		// TODO Auto-generated method stub
		email=email.trim();
		System.out.println(email);
		String[] ss=email.split("@");
		System.out.println(ss.length);
		for(int i=0;i<ss.length;i++)
		{
			System.out.print(ss[i]+"\t");
		}
		System.out.println();
		if(ss.length!=2)
			return false;
		if(ss[0].length()>0&&ss[1].length()>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean RegisterOneUser(String userName, String password,
			String job, String company, String school, String degree,
			String major, String country, String province, String city,
			String address, String zip, String emailAddress, String phoneNum,String motto) {
		// TODO Auto-generated method stub
		
		ScholarUser user=new ScholarUser();
		user.setUserName(userName);
		user.setPassword(password);
		user.setJob(job);
		user.setCompany(company);
		user.setSchool(school);
		user.setDegree(degree);
		user.setMajor(major);
		user.setCountry(country);
		user.setProvince(province);
		user.setCity(city);
		user.setAddress(address);
		user.setZip(zip);
		user.setEmailAddress(emailAddress);
		user.setPhoneNum(phoneNum);
		user.setMotto(motto);
		
		//把自己作为第一个好友
		user.getFriends().add(user);

		return scholarUserDao.saveOneUser(user);
	}

	@Override
	public User GetUserInfoByUidFromSinaWeibo(String uid,String token) {
		// TODO Auto-generated method stub
		
		Users users=new Users();
		users.setToken(token);
		User user=null;
		try {
			user=users.showUserById(uid);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean SaveSinaUser(User user) {
		// TODO Auto-generated method stub
		
		return scholarUserDao.addOneSinaUser(user);
	}

	@Override
	public boolean SetScholarUserSinaInfo(String userName, User user) {
		// TODO Auto-generated method stub
		ScholarUser scholarUser=scholarUserDao.getScholarUserByName(userName);
		//System.out.println(scholarUser.getUserName()+"\t"+scholarUser.getUserId());
		//System.out.println(user.getScreenName());
		return scholarUserDao.addScholarUserSinaInfo(scholarUser, user);
	}

	@Override
	public AccessToken GetAccessTokenByUserName(String userName) {
		// TODO Auto-generated method stub
		return scholarUserDao.getAccessTokenByUserName(userName);
	}

	@Override
	public boolean SaveAccessTokenForScholarUser(String userName,AccessToken accessToken) {
		// TODO Auto-generated method stub
		ScholarUser scholarUser=scholarUserDao.getScholarUserByName(userName);
		return scholarUserDao.saveAccessTokenForScholarUser(scholarUser,accessToken);
	}

	@Override
	public List<ScholarUser> GetAllUser(int pageIndex) {
		// TODO Auto-generated method stub
		
		return scholarUserDao.getAllUsers(pageIndex);
	
	}

	@Override
	public ScholarUser GetScholarUserById(int userId) {
		
		return scholarUserDao.getScholarUserById(userId);
	}

	@Override
	public int getTotalUserNum() {
		// TODO Auto-generated method stub
		
		
		
		return scholarUserDao.getTotalUserNum();
	}

	@Override
	public void DeleteAllRecForUser(int userId) {
		// TODO Auto-generated method stub
		scholarUserDao.delRecommendByUserId(userId);
	}

	@Override
	public boolean SaveOneUser(ScholarUser user) {
		// TODO Auto-generated method stub
		return scholarUserDao.saveOneUser(user);
	}







	
	




}
