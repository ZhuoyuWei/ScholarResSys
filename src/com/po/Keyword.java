package com.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Keyword {
	


	public Set<Paper> getPaperSet() {
		return paperSet;
	}
	public void setPaperSet(Set<Paper> paperSet) {
		this.paperSet = paperSet;
	}
	public Set<Book> getBookSet() {
		return bookSet;
	}
	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	public Set<Blog> getBlogSet() {
		return blogSet;
	}
	public void setBlogSet(Set<Blog> blogSet) {
		this.blogSet = blogSet;
	}
	public Set<OnelineCourse> getCourseSet() {
		return courseSet;
	}
	public void setCourseSet(Set<OnelineCourse> courseSet) {
		this.courseSet = courseSet;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public String getKeywordToken() {
		return keywordToken;
	}
	public void setKeywordToken(String keywordToken) {
		this.keywordToken = keywordToken;
	}



	public Set<Item> getItemSet() {
		return itemSet;
	}
	public void setItemSet(Set<Item> itemSet) {
		this.itemSet = itemSet;
	}



	private String keywordToken;
	private double score;
	private Set<Paper> paperSet=new HashSet<Paper>();
	private Set<Book> bookSet=new HashSet<Book>();
	private Set<Blog> blogSet=new HashSet<Blog>();
	private Set<OnelineCourse> courseSet=new HashSet<OnelineCourse>();
	private Set<Item> itemSet=new HashSet<Item>();
}
