package com.service;

import java.util.List;

import weibo4j.http.AccessToken;
import weibo4j.model.User;

import com.po.ScholarUser;

public interface AccountService {
	boolean CheckUserNameAvailable(String userName);
	ScholarUser GetScholarUserByName(String userName);
	ScholarUser GetScholarUserById(int userId);	
	AccessToken GetAccessTokenByUserName(String userName);
	boolean SaveAccessTokenForScholarUser(String userName,AccessToken accessToken);
	boolean CheckUserNameAndPassword(String userName,String password);
	boolean CheckEmail(String email);
	boolean RegisterOneUser(String userName,String password,String job
			,String company,String school,String degree,String major
			,String country,String province,String city,String address
			,String zip,String emailAddress,String phoneNum,String motto);
	
	
	//weibo api
	User GetUserInfoByUidFromSinaWeibo(String uid,String token);

	
	//mysql
	boolean SaveSinaUser(User user);
	boolean SetScholarUserSinaInfo(String userName,User user);

	List<ScholarUser> GetAllUser(int pageIndex);
	int getTotalUserNum();
	
	void DeleteAllRecForUser(int userId);
	boolean SaveOneUser(ScholarUser user);
	
	
}
