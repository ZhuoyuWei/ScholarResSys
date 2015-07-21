package com.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.AccountService;

public class RegisterAction extends ActionSupport{
	


	public String RegisterPage()
	{
		return "SUC";
	}
	public String Register()
	{

		System.out.println("********************************");
		System.out.println(this.s_userName);		
		System.out.println(this.s_password);
		System.out.println(this.s_confirm);
		System.out.println(this.s_job);
		System.out.println(this.s_company);		
		System.out.println(this.s_school);			
		System.out.println(this.s_degree);		
		System.out.println(this.s_major);			
		System.out.println(this.s_country);	
		System.out.println(this.s_province);			
		System.out.println(this.s_city);		
		System.out.println(this.s_address);			
		System.out.println(this.s_zip);		
		System.out.println(this.s_emailAddress);			
		System.out.println(this.s_phoneNum);	
		System.out.println(this.s_motto);
		System.out.println("********************************");		
		
		if(s_userName==null||s_userName.length()<=0)
		{
			registerInfo="username can't be empty";
			System.out.println(registerInfo);
			return "ERR";
		}
		if(accountService.CheckUserNameAvailable(s_userName))
		{
			registerInfo="This username has existed!";
			System.out.println(registerInfo);
			return "ERR";
		}
		
		if(s_password==null||s_confirm==null||s_password.length()<=0||s_confirm.length()<=0||!s_password.equals(s_confirm))
		{
			registerInfo="password and repeat password are not same!";
			System.out.println(registerInfo);
			return "ERR";
		}
		if(!accountService.CheckEmail(s_emailAddress))
		{
			registerInfo="email is not valid";
			System.out.println(registerInfo);
			return "ERR";
		}
		
		
		
		if(accountService.RegisterOneUser(s_userName, s_password, s_job, s_company, s_school, 
				s_degree, s_major, s_country, s_province, s_city, s_address, s_zip, s_emailAddress,
				s_phoneNum,s_motto))
		{
			registerInfo="";
			return "SUC";
		}
		else
		{
			registerInfo="Register is not successful!";
			System.out.println(registerInfo);
			return "ERR";
		}
	}

	
	
	
	public String getRegisterInfo() {
		return registerInfo;
	}
	public void setRegisterInfo(String registerInfo) {
		this.registerInfo = registerInfo;
	}

	public String getS_userName() {
		return s_userName;
	}
	public void setS_userName(String s_userName) {
		this.s_userName = s_userName;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_confirm() {
		return s_confirm;
	}
	public void setS_confirm(String s_confirm) {
		this.s_confirm = s_confirm;
	}
	public String getS_job() {
		return s_job;
	}
	public void setS_job(String s_job) {
		this.s_job = s_job;
	}
	public String getS_company() {
		return s_company;
	}
	public void setS_company(String s_company) {
		this.s_company = s_company;
	}
	public String getS_school() {
		return s_school;
	}
	public void setS_school(String s_school) {
		this.s_school = s_school;
	}
	public String getS_degree() {
		return s_degree;
	}
	public void setS_degree(String s_degree) {
		this.s_degree = s_degree;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	public String getS_country() {
		return s_country;
	}
	public void setS_country(String s_country) {
		this.s_country = s_country;
	}
	public String getS_province() {
		return s_province;
	}
	public void setS_province(String s_province) {
		this.s_province = s_province;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	public String getS_zip() {
		return s_zip;
	}
	public void setS_zip(String s_zip) {
		this.s_zip = s_zip;
	}
	public String getS_emailAddress() {
		return s_emailAddress;
	}
	public void setS_emailAddress(String s_emailAddress) {
		this.s_emailAddress = s_emailAddress;
	}
	public String getS_phoneNum() {
		return s_phoneNum;
	}
	public void setS_phoneNum(String s_phoneNum) {
		this.s_phoneNum = s_phoneNum;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String getS_motto() {
		return s_motto;
	}
	public void setS_motto(String s_motto) {
		this.s_motto = s_motto;
	}




	private String registerInfo;
	
	private String s_userName;   //用户填写的具有唯一标示的登录凭证
	private String s_password;
	private String s_confirm;
	
	private String s_job;        //工作或行业
	private String s_company;    //公司或组织
	private String s_school;     //毕业院校
	private String s_degree;     //最高学历
	private String s_major;       //专业领域
	


	private String s_country;    //国籍
	private String s_province;   //省份
	private String s_city;       //城市
	private String s_address;     //住址
	private String s_zip;        //邮编
	
	private String s_emailAddress;    //email地址
	private String s_phoneNum;      //电话号码
	
	private String s_motto;  //座右铭
	
	private AccountService accountService;
}
