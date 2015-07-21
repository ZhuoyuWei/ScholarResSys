package com.po;

import java.util.Date;

public class Comment {
	
	public Comment()
	{}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	private int commentId;
	private ScholarUser createby;
	private Item item;
	private String content;
	private Date createTime;
}
