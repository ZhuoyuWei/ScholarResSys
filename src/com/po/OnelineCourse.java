package com.po;

import java.util.ArrayList;
import java.util.List;

public class OnelineCourse extends Item{
	public OnelineCourse()
	{
		super();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getShort_des() {
		return short_des;
	}

	public void setShort_des(String short_des) {
		this.short_des = short_des;
	}


	public List<String> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<String> authorList) {
		this.authorList = authorList;
	}


	private List<String> authorList=new ArrayList<String>();
	private String imageUrl;
	private String short_des;
	
	private String content;

	
}
