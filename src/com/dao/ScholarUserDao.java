package com.dao;

import java.util.List;

import weibo4j.http.AccessToken;
import weibo4j.model.User;

import com.po.Item;
import com.po.ScholarUser;

public interface ScholarUserDao {
	ScholarUser getScholarUserByName(String userName);
	ScholarUser getScholarUserById(int userId);	
	ScholarUser getScholarUserByNameWithItems(String userName);	
	ScholarUser getScholarUserByNameAndPassword(String userName,String password);
	boolean saveOneUser(ScholarUser user);
	boolean addOneItemForUser(ScholarUser user,Item item);
	boolean addOneUserForUser(ScholarUser sourceUser,ScholarUser targetUser); //add one friend....
	boolean addSeveralFriendsForUser(ScholarUser sourceUser,List list);
	
	boolean addOneSinaUser(User user);
	boolean addScholarUserSinaInfo(ScholarUser scholarUser,User sinaUser);
	boolean addSinaFriends(User user,String[] friendIds);
	
	List getScholarFriendsForSina(ScholarUser scholarUser);
	AccessToken getAccessTokenByUserName(String userName);
	boolean saveAccessTokenForScholarUser(ScholarUser user,AccessToken accessToken);
	
	List<ScholarUser> getAllUsers(int pageIndex);
	int getTotalUserNum();
	void delRecommendByUserId(int userId);
}
