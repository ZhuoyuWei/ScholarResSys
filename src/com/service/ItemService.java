package com.service;

import java.util.List;

import com.po.Blog;
import com.po.Book;
import com.po.Item;
import com.po.Keyword;
import com.po.OnelineCourse;
import com.po.Paper;

public interface ItemService {
	Paper BuildOnePaper(String itemName,String major,String tagsString,String authorString
			,String paperType,String journal,String conference,String abstractContent
			,String linkUrl,String pubYearString);
	Book BuildOneBook(String itemName, String major, String tagsString,String authorString,
			String abstractContent,String pubYearString,String publisher,String linkUrl);
	Blog BuildOneBlog(String itemName, String major, String tagsString,String authorString,
			String abstractContent,String blogName,String url);	
	OnelineCourse BuildOneCourse(String itemName, String major,String tagsString,
			String abstractContent, String linkUrl,String authorString,String imageUrl);		
	boolean AddOneItem(Item item);	
	boolean AddOneKeyword(Keyword keyword);		
	boolean UserAcceptOneItem(String userName,Item item);
	Item GetItemByItemId(int itemId);
	boolean Comment(String userName,int itemId,String context);
	List GetCommentByItemId(int itemId);
	List GetCommentByItemId(Item item);	
	
	Paper GetPaperByKddIndex(int kddIndex);
	
	List<Item> GetAllItems();
	List<Item> GetAllItems(int pageIndex);
	int GetAllItemCount();
	
	Keyword GetKeywordByToken(String token);
	
	
	
}
