package main.java.com.mkyong.common.action;

import com.opensymphony.xwork2.ActionSupport;

public class CheckBoxAction extends ActionSupport{

	private boolean checkMe;

	public boolean isCheckMe() {
		return checkMe;
	}

	public void setCheckMe(boolean checkMe) {
		this.checkMe = checkMe;
	}

	public String execute() {
	
		return SUCCESS;
	
	}
	
	public String display() {
		
		return NONE;
	
	}
	

}