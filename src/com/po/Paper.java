package com.po;

import java.util.ArrayList;
import java.util.List;

public class Paper extends Item {
	
	public Paper()
	{
		super();
	}
	
	public List<String> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<String> authorList) {
		this.authorList = authorList;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getAbstractContent() {
		return abstractContent;
	}
	public void setAbstractContent(String abstractContent) {
		this.abstractContent = abstractContent;
	}
	


	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}



	public int getKddIndex() {
		return kddIndex;
	}

	public void setKddIndex(int kddIndex) {
		this.kddIndex = kddIndex;
	}





	private List<String> authorList=new ArrayList<String>();
	private String paperType;
	private String journal;
	private String conference;
	private String abstractContent;
	
	private int pubYear;
	
	private int kddIndex;
}
