package com.service.impl;

import java.util.Date;
import java.util.List;

import com.dao.ItemDao;
import com.dao.ScholarUserDao;
import com.po.Blog;
import com.po.Book;
import com.po.Item;
import com.po.Keyword;
import com.po.OnelineCourse;
import com.po.Paper;
import com.po.ScholarUser;
import com.po.Comment;
import com.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	private ScholarUserDao scholarUserDao;
	
	
	
	public ItemDao getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public ScholarUserDao getScholarUserDao() {
		return scholarUserDao;
	}
	public void setScholarUserDao(ScholarUserDao scholarUserDao) {
		this.scholarUserDao = scholarUserDao;
	}
	
	@Override
	public Paper BuildOnePaper(String itemName, String major,
			String tagsString, String authorString, String paperType,
			String journal, String conference, String abstractContent,
			String linkUrl, String pubYearString) {
		// TODO Auto-generated method stub
		Paper paper=new Paper();
		paper.setItemName(itemName);
		paper.setItemType("paper");
		paper.setMajor(major);
		paper.setPaperType(paperType);
		paper.setJournal(journal);
		paper.setConference(conference);
		paper.setAbstractContent(abstractContent);
		paper.setLinkUrl(linkUrl);
		
		int pubYear=-1;
		try
		{
			pubYear=Integer.parseInt(pubYearString);
		}catch(Exception e)
		{
			//pubYear=-1;
		}
		paper.setPubYear(pubYear);
		
		tagsString=tagsString.trim();
		String[] tagList=tagsString.split("[\\s]+");
		for(int i=0;i<tagList.length;i++)
		{
			if(tagList[i].length()>=1)
				paper.getTags().add(tagList[i]);
		}
		
		authorString=authorString.trim();
		String[] authorList=authorString.split("[\\s]+");
		for(int i=0;i<authorList.length;i++)
		{
			paper.getAuthorList().add(authorList[i]);
		}
		return paper;
	}
	@Override
	public boolean UserAcceptOneItem(String userName, Item item) {
		// TODO Auto-generated method stub
		//ScholarUser user=scholarUserDao.getScholarUserByNameWithItems(userName);
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		if(user==null)
			return false;
		return scholarUserDao.addOneItemForUser(user, item);
	}
	@Override
	public boolean AddOneItem(Item item) {
		// TODO Auto-generated method stub
		return itemDao.saveOneItem(item);
	}
	@Override
	public Item GetItemByItemId(int itemId) {
		// TODO Auto-generated method stub
		return itemDao.GetItemByItemId(itemId);
	}
	@Override
	public boolean Comment(String userName, int itemId, String context) {
		// TODO Auto-generated method stub
		ScholarUser user=scholarUserDao.getScholarUserByName(userName);
		Item item=itemDao.GetItemByItemId(itemId);
		Comment comment=new Comment();
		comment.setItem(item);
		comment.setCreateby(user);
		comment.setCreateTime(new Date());
		comment.setContent(context);
		return itemDao.addOneComment(comment);
	}
	@Override
	public List GetCommentByItemId(int itemId) {
		// TODO Auto-generated method stub
		
		Item item=itemDao.GetItemByItemId(itemId);
		return itemDao.getCommentsByItem(item);
	}
	@Override
	public List GetCommentByItemId(Item item) {
		// TODO Auto-generated method stub
		return itemDao.getCommentsByItem(item);		
		//return null;
	}
	@Override
	public Book BuildOneBook(String itemName, String major, String tagsString,String authorString,
			String abstractContent,String pubYearString,String publisher,String linkUrl){
		// TODO Auto-generated method stub
		
		Book book=new Book();
		book.setItemName(itemName);
		book.setItemType("book");
		book.setMajor(major);
		book.setPublisher(publisher);
		
		int pubYear=-1;
		try
		{
			pubYear=Integer.parseInt(pubYearString);
		}catch(Exception e)
		{
			//pubYear=-1;
		}
		book.setPubYear(pubYear);
		book.setAbstractContent(abstractContent);
		book.setLinkUrl(linkUrl);
		
		tagsString=tagsString.trim();
		String[] tagList=tagsString.split("[\\s]+");
		for(int i=0;i<tagList.length;i++)
		{
			if(tagList[i].length()>=1)
				book.getTags().add(tagList[i]);
		}
		
		authorString=authorString.trim();
		String[] authorList=authorString.split("[\\s]+");
		for(int i=0;i<authorList.length;i++)
		{
			book.getAuthorList().add(authorList[i]);
		}
		
		return book;
	}
	@Override
	public Blog BuildOneBlog(String itemName, String major, String tagsString,
			String authorString, String abstractContent, String blogName,
			String url) {
		// TODO Auto-generated method stub
		Blog blog=new Blog();
		blog.setItemName(itemName);
		blog.setItemType("blog");
		blog.setAuthor(authorString);
		blog.setDiscription(abstractContent);
		blog.setMajor(major);
		blog.setBlogName(blogName);
		blog.setLinkUrl(url);
		
		tagsString=tagsString.trim();
		String[] tagList=tagsString.split("[\\s]+");
		for(int i=0;i<tagList.length;i++)
		{
			if(tagList[i].length()>=1)
				blog.getTags().add(tagList[i]);
		}
		return blog;
	}
	@Override
	public OnelineCourse BuildOneCourse(String itemName, String major,String tagsString,
			String abstractContent, String linkUrl,String authorString,String imageUrl) {
		// TODO Auto-generated method stub
		OnelineCourse course=new OnelineCourse();
		course.setItemName(itemName);
		course.setMajor(major);
		course.setContent(abstractContent);
		course.setItemType("online");
		course.setLinkUrl(linkUrl);
		course.setImageUrl(imageUrl);
		
		tagsString=tagsString.trim();
		String[] tagList=tagsString.split("[\\s]+");
		for(int i=0;i<tagList.length;i++)
		{
			if(tagList[i].length()>=1)
				course.getTags().add(tagList[i]);
		}
		
		authorString=authorString.trim();
		String[] authorList=authorString.split("[\\s]+");
		for(int i=0;i<authorList.length;i++)
		{
			course.getAuthorList().add(authorList[i]);
		}
		
		return course;
	}
	@Override
	public Paper GetPaperByKddIndex(int kddIndex) {
		// TODO Auto-generated method stub
		
		return itemDao.getPaperByKddIndex(kddIndex);
	}
	@Override
	public List<Item> GetAllItems(int pageIndex) {
		// TODO Auto-generated method stub

		return itemDao.getAllItems(pageIndex);
	}
	@Override
	public List<Item> GetAllItems() {
		// TODO Auto-generated method stub

		return itemDao.getAllItems();
	}
	@Override
	public int GetAllItemCount() {
		// TODO Auto-generated method stub
		return itemDao.getAllItemCount();
	}
	@Override
	public boolean AddOneKeyword(Keyword keyword) {
		// TODO Auto-generated method stub
		return itemDao.saveOneKeyword(keyword);
	}
	@Override
	public Keyword GetKeywordByToken(String token) {
		// TODO Auto-generated method stub
		return itemDao.getKeywordByToken(token);
	}


	
	
}
