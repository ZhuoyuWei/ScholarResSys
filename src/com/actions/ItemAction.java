package com.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.service.*;
import com.po.*;




public class ItemAction implements ServletRequestAware{
	
	public String AddOneItem()
	{
		ActionContext ctx=ActionContext.getContext();
		Object oitemType=request.getAttribute("addItemType");
		if(oitemType==null)
		{
			System.out.println("fuck! it is empty!");
			return "PAPER";
		}
		String itemType=oitemType.toString();
		if(itemType.equals("paper"))
			return "PAPER";
		return "ERR";
	}
	
	public String AddPaperJsp()
	{
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		return "SUC";
	}
	public String AddBookJsp()
	{
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		return "SUC";
	}	
	public String AddBlogJsp()
	{
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		return "SUC";
	}
	public String AddOnlineCourseJsp()
	{
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		return "SUC";
	}	
	
	
	public String AddOnePaperSub()
	{	
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		Item paper=itemService.BuildOnePaper(s_itemName, s_major, s_tagString, s_authorString, s_paperType
				, s_journal, s_conference, s_abstractContent, s_linkUrl, s_pubYear);
		boolean flag=itemService.AddOneItem(paper);
		if(!flag)
		{
			return "ERR";
		}
		flag=itemService.UserAcceptOneItem(o.toString(), paper);
		if(!flag)
		{
			return "ERR";
		}
		
		//System.exit(-1);
		if(post_to_weibo)
		{
			String url="http://www.scholarrecsys.com/ScholarResSys/ItemInfo?itemId="+paper.getItemId();
			String publishUrl="<br><a href=\""+url+"\">paper</a>";
			flag=infoService.PublishOneTweet(o.toString(), paper, s_publishTweetContext+" "+publishUrl);
			if(!flag)
			{
				return "ERR";
			}
		}
				
		//清空表单
		s_itemName="";
		s_major="";
		s_authorString="";
		s_paperType="";
		s_journal="";
		s_conference="";
		s_abstractContent="";
		s_tagString="";
		s_linkUrl="";
		s_pubYear="";
		
		s_publishTweetContext="";
		s_publisher="";
		s_imageUrl="";
		
		return "SUC";
	}
	
	public String AddOneBookSub()
	{	
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		Item book=itemService.BuildOneBook(s_itemName, s_major, s_tagString, s_authorString, s_abstractContent,
				s_pubYear, s_publisher, s_linkUrl);
		boolean flag=itemService.AddOneItem(book);
		if(!flag)
		{
			return "ERR";
		}
		flag=itemService.UserAcceptOneItem(o.toString(), book);
		if(!flag)
		{
			return "ERR";
		}
		
		//System.exit(-1);
		if(post_to_weibo)
		{
			
			String url="http://www.scholarrecsys.com/ScholarResSys/ItemInfo?itemId="+book.getItemId();
			String publishUrl="<br><a href=\""+url+"\">book</a>";
			flag=infoService.PublishOneTweet(o.toString(), book, s_publishTweetContext+" "+publishUrl);
			if(!flag)
			{
				return "ERR";
			}
		}
		
		//清空表单
		s_itemName="";
		s_major="";
		s_authorString="";
		s_paperType="";
		s_journal="";
		s_conference="";
		s_abstractContent="";
		s_tagString="";
		s_linkUrl="";
		s_pubYear="";
		
		s_publishTweetContext="";
		s_publisher="";
		s_imageUrl="";	
		
		
		return "SUC";
	}
	
	
	public String AddOneBlogSub()
	{	
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		Item blog=itemService.BuildOneBlog(s_itemName, s_major, s_tagString, s_authorString,
				s_abstractContent,s_blogName, s_linkUrl);
		boolean flag=itemService.AddOneItem(blog);
		if(!flag)
		{
			return "ERR";
		}
		flag=itemService.UserAcceptOneItem(o.toString(), blog);
		if(!flag)
		{
			return "ERR";
		}
		
		//System.exit(-1);
		if(post_to_weibo)
		{
			String url="http://www.scholarrecsys.com/ScholarResSys/ItemInfo?itemId="+blog.getItemId();
			String publishUrl="<br><a href=\""+url+"\">blog</a>";
			flag=infoService.PublishOneTweet(o.toString(), blog, s_publishTweetContext+" "+publishUrl);
			if(!flag)
			{
				return "ERR";
			}
		}
		
		//清空表单
		s_itemName="";
		s_major="";
		s_authorString="";
		s_paperType="";
		s_journal="";
		s_conference="";
		s_abstractContent="";
		s_tagString="";
		s_linkUrl="";
		s_pubYear="";
		
		s_publishTweetContext="";
		s_publisher="";
		s_imageUrl="";	
		s_blogName="";
		
		return "SUC";
	}
	
	public String AcceptOneItem()
	{
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";	
		Map map=ctx.getParameters();
		Object o2=map.get("itemId");
		if(o2==null)
			return "ERR";
		Integer itemId=Integer.parseInt(((String[])o2)[0]);
		Item item=itemService.GetItemByItemId(itemId);
		if(item==null)
			return "ERR";
		boolean flag=itemService.UserAcceptOneItem(o.toString(), item);
		if(!flag)
		{
			return "ERR";
		}
		return "SUC";
	}
	
	public String AddOneOnlineCourseSub()
	{	
		ActionContext ctx=ActionContext.getContext();		
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOGIN";
		OnelineCourse course=itemService.BuildOneCourse(s_itemName, s_major, s_tagString,
				s_abstractContent, s_linkUrl,s_authorString,s_imageUrl);
		boolean flag=itemService.AddOneItem(course);
		if(!flag)
		{
			return "ERR";
		}
		flag=itemService.UserAcceptOneItem(o.toString(), course);
		if(!flag)
		{
			return "ERR";
		}
		
		//System.exit(-1);
		if(post_to_weibo)
		{
			String url="http://www.scholarrecsys.com/ScholarResSys/ItemInfo?itemId="+course.getItemId();
			String publishUrl="<br><a href=\""+url+"\">course</a>";
			flag=infoService.PublishOneTweet(o.toString(), course, s_publishTweetContext+" "+publishUrl);
			if(!flag)
			{
				return "ERR";
			}
		}
		
		//清空表单
		s_itemName="";
		s_major="";
		s_authorString="";
		s_paperType="";
		s_journal="";
		s_conference="";
		s_abstractContent="";
		s_tagString="";
		s_linkUrl="";
		s_pubYear="";
		
		s_publishTweetContext="";
		s_publisher="";
		s_imageUrl="";	
		
		
		return "SUC";
	}
	
	
	public String ToItemInfoPage()
	{
		ActionContext ctx=ActionContext.getContext();
		Map map=ctx.getParameters();
		Object o2=map.get("itemId");
		
		if(o2!=null)
		{
			itemId=Integer.parseInt(((String[])o2)[0]);
		}
		//else
		//{
			//itemId=1;
		//}
		
		Item item=itemService.GetItemByItemId(itemId);
		if(item==null)
			return "ERR";
		String classString=item.getClass().toString();
		
		ctx.put("item", item);
		List list=itemService.GetCommentByItemId(item);
		if(list==null)
			list=new ArrayList<Comment>();
		ctx.put("CommentList", list);
		if(classString.contains("Paper"))
			return "PAPER";
		else if(classString.contains("Book"))
			return "BOOK";
		else if(classString.contains("Blog"))
			return "BLOG";
		else if(classString.contains("OnelineCourse"))
			return "ONLINE";
		else
			return "ERR";
	}
	
	public String AddOneComment()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		if(o==null)
			return "LOG";
		String userName=o.toString();
		System.out.println("Is still here "+itemId);
		boolean flag=itemService.Comment(userName, itemId, s_comment);
		if(flag)
		{
			s_comment="";
			ctx.put("itemId", itemId);
			return "SUC";
		}
		else
		{
			System.out.println("really err!");
			return "ERR";
		}
	}
	
	public String ShowAllItems()
	{
		//要传一个ItemList到前端JSP去
		ActionContext ctx=ActionContext.getContext();
		Map map=ctx.getParameters();
		Object o2=map.get("pageIndex");
		Integer pageIndex=0;
		if(o2!=null)
		{
			pageIndex=Integer.parseInt(((String[])o2)[0]);
		}
		List<Item> itemList=itemService.GetAllItems(pageIndex);
		ctx.put("itemList", itemList);
		
		int totalItem=itemService.GetAllItemCount();
		int totalPage=totalItem/this.itemPageSize;
		if(totalItem%this.itemPageSize>0)
			totalPage++;
		ctx.put("totalPage", totalPage);
		
		return "SUC";
	}
	public String ShowMyItems()
	{
		//要传一个ItemList到前端JSP去		
		
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
			return "LOG";
		ScholarUser user=accountService.GetScholarUserByName(o.toString());
		List<Item> itemList=new ArrayList<Item>();
		itemList.addAll(user.getItems());
		int startIndex=pageIndex*this.itemPageSize;
		List<Item> tempList=new ArrayList<Item>();
		for(int i=0;i<this.itemPageSize;i++)
		{
			if((i+startIndex)>=itemList.size())
				break;
			tempList.add(itemList.get(i+startIndex));
		}
		ctx.put("itemList", tempList);
		
		int totalPage=user.getItems().size()/this.itemPageSize;
		if(user.getFriends().size()%this.itemPageSize>0)
			totalPage++;
		ctx.put("totalPage", totalPage);
		
		return "SUC";
	}	
	
	
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	public String getS_itemType() {
		return s_itemType;
	}

	public void setS_itemType(String s_itemType) {
		this.s_itemType = s_itemType;
	}

	public String getS_itemName() {
		return s_itemName;
	}

	public void setS_itemName(String s_itemName) {
		this.s_itemName = s_itemName;
	}

	public String getS_major() {
		return s_major;
	}

	public void setS_major(String s_major) {
		this.s_major = s_major;
	}

	public String getS_paperType() {
		return s_paperType;
	}

	public void setS_paperType(String s_paperType) {
		this.s_paperType = s_paperType;
	}

	public String getS_journal() {
		return s_journal;
	}

	public void setS_journal(String s_journal) {
		this.s_journal = s_journal;
	}

	public String getS_conference() {
		return s_conference;
	}

	public void setS_conference(String s_conference) {
		this.s_conference = s_conference;
	}

	public String getS_abstractContent() {
		return s_abstractContent;
	}

	public void setS_abstractContent(String s_abstractContent) {
		this.s_abstractContent = s_abstractContent;
	}

	public String getS_tagString() {
		return s_tagString;
	}

	public void setS_tagString(String s_tagString) {
		this.s_tagString = s_tagString;
	}

	public String getS_linkUrl() {
		return s_linkUrl;
	}

	public void setS_linkUrl(String s_linkUrl) {
		this.s_linkUrl = s_linkUrl;
	}

	public String getS_pubYear() {
		return s_pubYear;
	}

	public void setS_pubYear(String s_pubYear) {
		this.s_pubYear = s_pubYear;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/*public boolean isPublish() {
		return isPublish;
	}

	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}*/

	
	public String getS_publishTweetContext() {
		return s_publishTweetContext;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

	public void setS_publishTweetContext(String s_publishTweetContext) {
		this.s_publishTweetContext = s_publishTweetContext;
	}

	
	public String getS_authorString() {
		return s_authorString;
	}

	public void setS_authorString(String s_authorString) {
		this.s_authorString = s_authorString;
	}

	
	
	public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public boolean isCheckMe() {
		return checkMe;
	}

	public void setCheckMe(boolean checkMe) {
		this.checkMe = checkMe;
	}
	
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	

	public String getS_publisher() {
		return s_publisher;
	}

	public void setS_publisher(String s_publisher) {
		this.s_publisher = s_publisher;
	}

	public String getS_imageUrl() {
		return s_imageUrl;
	}

	public void setS_imageUrl(String s_imageUrl) {
		this.s_imageUrl = s_imageUrl;
	}


	public String getS_blogName() {
		return s_blogName;
	}

	public void setS_blogName(String s_blogName) {
		this.s_blogName = s_blogName;
	}

	
	
	

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	

	private String s_itemType;
	private String s_itemName;
	private String s_major;
	private String s_authorString;
	private String s_paperType;
	private String s_journal;
	private String s_conference;
	private String s_abstractContent;
	private String s_tagString;
	private String s_linkUrl;
	private String s_pubYear;
	
	//private boolean isPublish;
	private String isPublish;
	private String s_publishTweetContext;
	
	
	private InfoService infoService;
	private ItemService itemService;
	private AccountService accountService;
	private HttpServletRequest request;
	private int itemPageSize=16;
	
	
	private boolean checkMe;
	private int itemId;
	
	private boolean post_to_weibo;
	
	
	
	
	public boolean isPost_to_weibo() {
		return post_to_weibo;
	}

	public void setPost_to_weibo(boolean post_to_weibo) {
		this.post_to_weibo = post_to_weibo;
	}

	public String getS_comment() {
		return s_comment;
	}

	public void setS_comment(String s_comment) {
		this.s_comment = s_comment;
	}
	//Comment
	private String s_comment;
	
	//Book
	private String s_publisher;
	private String s_imageUrl;
	
	//Blog
	private String s_blogName;
}
