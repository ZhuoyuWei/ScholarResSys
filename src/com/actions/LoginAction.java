package com.actions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.crazyit.app.dao.PersonDao;
import org.crazyit.app.domain.Person;

import weibo4j.http.AccessToken;

import com.offline.PostDBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.po.Paper;
import com.service.AccountService;
import com.service.ItemService;



public class LoginAction extends ActionSupport implements ServletResponseAware{


	public boolean CheckUserLogin(String suserId,String spassword)
	{
		return false;
	}
	
	public String Login()
	{
		if(accountService.CheckUserNameAndPassword(s_userName, s_password))
		{
			loginInfo="";
			ActionContext ctx=ActionContext.getContext();
			ctx.getSession().put("userName", s_userName);
			
			//ctx.put(key, value)
			try {
				//System.out.println(System.getProperty("user.dir"));
				//InputStream in=new BufferedInputStream(new FileInputStream("/WEB-INF/classes/config.properties"));
				//Properties p=new Properties();
				//p.load(in);
				//ctx.put("client_id", p.get("client_ID").toString());
				//ctx.put("response_type", "code");
				//ctx.put("redirect_uri", p.get("redirect_URI").toString());
				//String url=p.getProperty("sinaOauthUrl").toString();
				//url+="?client_id="+p.get("client_ID").toString();
				//url+="&response_type=code&redirect_uri"+p.get("redirect_URI").toString();
				System.out.println(s_userName+" is logining in");
				AccessToken accessToken=accountService.GetAccessTokenByUserName(s_userName);
				
				if(accessToken==null)
				{
					String url="https://api.weibo.com/oauth2/authorize?client_id=983042473&response_type=code&redirect_uri=http://www.scholarrecsys.com/ScholarResSys/home";
					System.out.println(url);
					response.sendRedirect(url);
					return null;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "SUC";
		}
		else
		{
			loginInfo="Name or password is not correct!";
			return "ERR";
		}
	}
	
	
	
	public void GetPapers(Connection conn,PrintStream ps) throws SQLException
	{
		 conn.setAutoCommit(false);
		 Statement st = conn.createStatement();
		 st.setFetchSize(50);
		 ResultSet rs = st.executeQuery("SELECT * FROM paper");
		 Map<Integer,Paper> indexToPaper=new HashMap<Integer,Paper>();
		 int count=0;
		 while (rs.next()) {
			 count++;
			 //if(count>20)
				// break;
			 Paper paper=new Paper();
			 Integer index=rs.getInt(1);
			 if(index==null)
				 continue;
			 //indexToPaper.put(index, paper);
			 paper.setKddIndex(index);
			 String title=rs.getString(2);	
			 paper.setItemName(title);
			 paper.setItemType("paper");
			 Integer year=rs.getInt(3);
			 paper.setPubYear(year);
			 String keywords=rs.getString(6);
			 if(keywords==null)
				 continue;
			 String[] ss=keywords.split("[\\W]+");
			 for(int i=0;i<ss.length;i++)
			 {
				 paper.getTags().add(ss[i]);
			 }
			 if(paper.getItemName()!=null&&paper.getItemName().length()>=1)
			 {
					//itemService.AddOneItem(paper);
				 ps.print(paper.getKddIndex()+"{%&^&%}"+paper.getItemName()+"{%&^&%}"+paper.getPubYear()
						 +"{%&^&%}");
				 for(int i=0;i<paper.getTags().size();i++)
				 {
					 ps.print(paper.getTags().get(i)+"$@$");
				 }
				 ps.println();
			 }
		 }
		rs.close();
		
		/*rs=st.executeQuery("select * from paperauthor");
		count=0;
		while(rs.next())
		{
			count++;
			int paperid=rs.getInt(1);
			String author=rs.getString(3);
			
			Paper paper=itemService.GetPaperByKddIndex(paperid);
			if(paper==null)
				continue;
			paper.getAuthorList().add(author);
			itemService.AddOneItem(paper);
		}*/
		st.close();
		/*Iterator it=indexToPaper.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			Paper paper=(Paper)entry.getValue();
			if(paper.getItemName()!=null&&paper.getItemName().length()>=1)
				itemService.AddOneItem(paper);
		}*/
	}	
	
	
	public String StartPage()
	{
		/*long start=System.currentTimeMillis();
		try {
		Class.forName( "org.postgresql.Driver" ).newInstance();
        
		String url = "jdbc:postgresql://localhost:5432/kdd2013" ;
		                 
		Connection conn= DriverManager.getConnection(url, "postgres" , "1234" );
		PrintStream ps=new PrintStream("E:\\Workspaces\\MyEclipse 10\\ScholarResSys_forder\\data\\paperKdd\\paper.info");
		GetPapers(conn,ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long end=System.currentTimeMillis();
		System.out.println("**********From Postgresql to mysql "+(end-start)+"ms");*/
		return "SUC";
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

	public String getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	private String s_userName;
	private String s_password;
	private String loginInfo;


	private PersonDao personDao;
	private AccountService accountService;
	private ItemService itemService;
	
	
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}


	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	
	private HttpServletResponse response;

	
}
