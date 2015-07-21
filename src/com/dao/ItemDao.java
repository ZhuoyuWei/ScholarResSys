package com.dao;

import java.util.List;

import com.po.Comment;
import com.po.Item;
import com.po.Keyword;
import com.po.Paper;

public interface ItemDao {
	List getItemByUserName(String userName);
	boolean saveOneItem(Item item);
	boolean saveOneKeyword(Keyword keyword);	
	Item GetItemByItemId(int itemId);
	boolean addOneComment(Comment com);
	List getCommentsByItem(Item item);
	Paper getPaperByKddIndex(int kddIndex);
	List<Item> getAllItems();
	List<Item> getAllItems(int pageIndex);
	int getAllItemCount();
	Keyword getKeywordByToken(String token);
}
