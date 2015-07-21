package com.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.po.ScholarUser;
import com.service.AccountService;
import com.service.FriendService;

public class FriendAction {
	
	public String ToAddFriendPage()
	{
		ActionContext ctx=ActionContext.getContext();
		Map params=ctx.getParameters();
		String[] list=(String[])params.get("friendsId");
		System.out.println("friendsId:"+list[0]);
		return "SUC";
	}
	public String AddOneFriend()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOG";
		String sourceUserName=o.toString();
		boolean flag=friendService.AddOneFriend(sourceUserName, s_friendName);
		if(flag)
			return "SUC";
		else
			return "ERR";
	}
	
	public String AddOneFriendEx()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOG";
		Map map=ctx.getParameters();
		String[] friendIDs=(String[])map.get("friendsId");
		if(friendIDs==null)
			return "NOF";
		Integer friendId=Integer.parseInt(friendIDs[0]);
		
		String sourceUserName=o.toString();
		ScholarUser friend=accountService.GetScholarUserById(friendId);
		String friendName=friend.getUserName();
		boolean flag=friendService.AddOneFriend(sourceUserName, friendName);
		if(flag)
			return "SUC";
		else
			return "ERR";
	}
	
	
	public String ShowMyFriends()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		Map map=ctx.getParameters();
		Object o2=map.get("pageIndex");
		Integer pageIndex=0;
		if(o2!=null)
		{
			pageIndex=Integer.parseInt(((String[])o2)[0]);
		}
		if(o==null)
			return "Log";
		ScholarUser user=accountService.GetScholarUserByName(o.toString());
		List<ScholarUser> suList=new ArrayList<ScholarUser>();
		suList.addAll(user.getFriends());
		List<ScholarUser> tempList=new ArrayList<ScholarUser>();
		int startIndex=pageIndex*this.userPageSize;
		for(int i=0;i<this.userPageSize;i++)
		{
			if((i+startIndex)>=suList.size())
				break;
			tempList.add(suList.get(i+startIndex));
		}
		ctx.put("friendList", tempList);
		int totalPage=user.getFriends().size()/this.userPageSize;
		if(user.getFriends().size()%this.userPageSize>0)
			totalPage++;
		ctx.put("totalPage", totalPage);
		return "SUC";
	}
	public String ShowAllPeople()
	{
		ActionContext ctx=ActionContext.getContext();
		Map map=ctx.getParameters();
		Object o2=map.get("pageIndex");
		Integer pageIndex=0;
		if(o2!=null)
		{
			pageIndex=Integer.parseInt(((String[])o2)[0]);
		}
		List<ScholarUser> suList=accountService.GetAllUser(pageIndex);
		ctx.put("friendList", suList);	
		int totalUser=accountService.getTotalUserNum();
		int totalPage=totalUser/this.userPageSize;
		if(totalUser%this.userPageSize>0)
			totalPage++;
		ctx.put("totalPage", totalPage);
		return "SUC";
	}	
	
	public String ShowPersonalInfo()
	{
		ActionContext ctx=ActionContext.getContext();
		Map params=ctx.getParameters();
		String[] list=(String[])params.get("friendsId");
		System.out.println("friendsId:"+list[0]);
		
		ScholarUser user=accountService.GetScholarUserById(Integer.parseInt(list[0]));
		ctx.put("User", user);
		return "SUC";
	}
	
	public String getS_friendName() {
		return s_friendName;
	}
	public void setS_friendName(String s_friendName) {
		this.s_friendName = s_friendName;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/*public List<ScholarUser> getPeopleList() {
		return peopleList;
	}
	public void setPeopleList(List<ScholarUser> peopleList) {
		this.peopleList = peopleList;
	}*/





	private String s_friendName;
	private FriendService friendService;
	private AccountService accountService;
	
	
	private int userPageSize=9;
	//private List<ScholarUser> peopleList;
}
