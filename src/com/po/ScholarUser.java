package com.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import weibo4j.http.AccessToken;

public class ScholarUser {
	
	public ScholarUser()
	{}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getWeiboScreenName() {
		return weiboScreenName;
	}
	public void setWeiboScreenName(String weiboScreenName) {
		this.weiboScreenName = weiboScreenName;
	}
	public Set<ScholarUser> getFriends() {
		return friends;
	}
	public void setFriends(Set<ScholarUser> friends) {
		this.friends = friends;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public Set<InterestGroup> getGroups() {
		return groups;
	}
	public void setGroups(Set<InterestGroup> groups) {
		this.groups = groups;
	}
	
	
	public Set<ScholarTweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<ScholarTweet> tweets) {
		this.tweets = tweets;
	}


	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public List<String> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}


	public Set<Item> getRecommendItems() {
		return recommendItems;
	}

	public void setRecommendItems(Set<Item> recommendItems) {
		this.recommendItems = recommendItems;
	}








	private int userId;  //用户id，自动生成
	private String userName;   //用户填写的具有唯一标示的登录凭证
	private String password;
	
	private String job;        //工作或行业
	private String company;    //公司或组织
	private String school;     //毕业院校
	private String degree;     //最高学历
	private String major;       //专业领域
	


	private String country;    //国籍
	private String province;   //省份
	private String city;       //城市
	private String address;     //住址
	private String zip;        //邮编
	
	private String emailAddress;    //email地址
	private String phoneNum;      //电话号码
	
	//新浪微博的

	private AccessToken accessToken;
	private String weiboScreenName;  
	
	
	private Set<ScholarUser> friends=new HashSet<ScholarUser>();
	private Set<Item> items=new HashSet<Item>();
	private Set<InterestGroup> groups=new HashSet<InterestGroup>();
	
	private Set<ScholarTweet> tweets=new HashSet<ScholarTweet>();
	
	private String motto;  //座右铭
	private List<String> keywordList=new ArrayList<String>();  //关键字 top n，是从tweet和comment中获得的，不是写的
	
	
	private Set<Item> recommendItems=new HashSet<Item>();
	
}
