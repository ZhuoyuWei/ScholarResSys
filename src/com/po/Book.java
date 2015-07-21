package com.po;

import java.util.ArrayList;
import java.util.List;

public class Book extends Item {
	
	public Book()
	{
		super();
	}
	
	
	public List<String> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<String> authorList) {
		this.authorList = authorList;
	}
	public String getAbstractContent() {
		return abstractContent;
	}
	public void setAbstractContent(String abstractContent) {
		this.abstractContent = abstractContent;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPubYear() {
		return pubYear;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}


	private List<String> authorList=new ArrayList<String>();
	private String abstractContent;
	
	private String publisher;
	private int year;
	private String imageUrl;
	private int pubYear;
}
