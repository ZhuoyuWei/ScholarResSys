package com.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item {
	
	public Item()
	{}
	


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	public String getLinkUrl() {
		return linkUrl;
	}



	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}


	public Set<Item> getSimilarItemSet() {
		return similarItemSet;
	}



	public void setSimilarItemSet(Set<Item> similarItemSet) {
		this.similarItemSet = similarItemSet;
	}



	public int hashCode()
	{
		return this.itemId;
	}
	
	
	public boolean equals(Object o)
	{
		Item item=(Item)o;
		if(this.itemId==item.itemId)
			return true;
		else
			return false;
	}





	private int itemId;
	private String itemType;
	private String itemName;
	private String major;
	private List<String> tags=new ArrayList<String>();
	
	private Set<Comment> comments=new HashSet<Comment>();
	private String linkUrl;
	
	
	//for recommendation
	//private List<Item> similarItemList=new ArrayList<Item>();
	private Set<Item> similarItemSet=new HashSet<Item>();
	
}
