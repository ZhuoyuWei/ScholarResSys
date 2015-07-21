package com.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterestGroup {
	
	public InterestGroup()
	{}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Set<ScholarUser> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<ScholarUser> userSet) {
		this.userSet = userSet;
	}

	private int groupId;
	private String groupName;
	private String discription;
	
	private List<String> tags=new ArrayList<String>();
	private Set<ScholarUser> userSet=new HashSet<ScholarUser>();
}
