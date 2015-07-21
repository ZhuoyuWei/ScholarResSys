package com.actions;


import java.util.List;

import weibo4j.Oauth;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.http.AccessToken;
import weibo4j.model.Status;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.opensymphony.xwork2.ActionContext;
import com.po.ScholarTweet;
import com.po.ScholarUser;
import com.service.AccountService;
import com.service.FriendService;
import com.service.InfoService;

public class HomeAction {
	
	public String LoadHomePage()
	{
		System.out.println("LoadHomePage");
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		
		if(o==null)
		{
			System.out.println("I'm going to LOGIN!");
			return "LOGIN";
		}
		s_userName=o.toString();
		AccessToken access_token=accountService.GetAccessTokenByUserName(s_userName);
		
		if(access_token==null)
		{
			System.out.println();
			Oauth oauth=new Oauth();

			try {
				access_token=oauth.getAccessTokenByCode(code);
			} catch (WeiboException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(access_token==null)
				return "OauthERR";
			boolean flag=accountService.SaveAccessTokenForScholarUser(s_userName, access_token);
			if(!flag)
				return "OauthERR";
			
		}
		
		ctx.getSession().put("access_token", access_token);
		List friendTweetList=infoService.GetFriendsTweet(s_userName);
		if(friendTweetList==null)
		{
			System.out.println("List is null");
		}
		System.out.println(friendTweetList.size());
		for(int i=0;i<friendTweetList.size();i++)
		{
			System.out.println(((ScholarTweet)(friendTweetList.get(i))).getContent());
			//System.out.println(((ScholarTweet)friendTweetList.get(i)).getContent());
		}
		ScholarUser su=accountService.GetScholarUserByName(s_userName);
		ctx.put("User", su);
		ctx.put("friendTweets", friendTweetList);
		
		
		return "SUC";
	}
	
	
	public String SynchronizeSinaInfo()
	{
		ActionContext ctx=ActionContext.getContext();
		AccessToken access_token=(AccessToken)ctx.getSession().get("access_token");
		if(access_token==null)
		{
			System.out.println("by wzy: AccessToken is not in Session");
			return "OauthERR";
		}
		String userName=ctx.getSession().get("userName").toString();
		String token=access_token.getAccessToken();
		String uid=access_token.getUid();		
		User user=accountService.GetUserInfoByUidFromSinaWeibo(uid, token);
		if(user==null)
		{
			System.out.println("by wzy: can't get user from sina weibo!");
			return "OauthERR";
		}
		boolean flag=accountService.SaveSinaUser(user);
		if(!flag)
		{
			System.out.println("by wzy:save sina user error");
			return "ERR";
		}
		flag=accountService.SetScholarUserSinaInfo(userName, user);
		if(!flag)
		{
			System.out.println("by wzy:Add user sina info for user error");
			return "ERR";
		}
		
		flag=friendService.GetAndSaveSinaFriends(user, token);
		if(!flag)
		{
			System.out.println("by wzy:get friends error");
			return "ERR";
		}	
		friendService.ChangeSinaFriendsToScholarFriends(userName);
		
		return "SUC";
	}
	
	public String PublishOneTweet()
	{
		infoService.PublishOneTweet(s_userName, null, s_publishTweetContext);
		if(post_to_weibo)
		{
			ActionContext ctx=ActionContext.getContext();
			AccessToken access_token=(AccessToken)ctx.getSession().get("access_token");
			if(access_token==null)
			{
				System.out.println("by wzy: AccessToken is not in Session");
				return "OauthERR";
			}
			String userName=ctx.getSession().get("userName").toString();
			String token=access_token.getAccessToken();
			String uid=access_token.getUid();	
			
			Timeline tm = new Timeline();
			tm.client.setToken(token);
			try {
				Status status = tm.UpdateStatus(s_publishTweetContext);
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}

		return "SUC";
	}
	
	
	public String getS_userName() {
		return s_userName;
	}
	public void setS_userName(String s_userName) {
		this.s_userName = s_userName;
	}

	public String getS_publishTweetContext() {
		return s_publishTweetContext;
	}

	public void setS_publishTweetContext(String s_publishTweetContext) {
		this.s_publishTweetContext = s_publishTweetContext;
	}

	public InfoService getInfoService() {
		return infoService;
	}
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public boolean isPost_to_weibo() {
		return post_to_weibo;
	}


	public void setPost_to_weibo(boolean post_to_weibo) {
		this.post_to_weibo = post_to_weibo;
	}




	private InfoService infoService;
	private AccountService accountService;
	private FriendService friendService;
	
	private String s_userName;
	private String s_publishTweetContext;
	
	
	//sina weibo 
	private String code;
	private boolean post_to_weibo;
	
	
	
	
	
}
