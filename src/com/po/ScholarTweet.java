package com.po;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ScholarTweet {
	
	public ScholarTweet()
	{}
	
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public ScholarUser getCreateby() {
		return createby;
	}
	public void setCreateby(ScholarUser createby) {
		this.createby = createby;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}


	private int tweetId;
	private ScholarUser createby;
	private Item item;
	private String content;
	private Calendar createTime;
	
	public static Random rand=new Random();
}
