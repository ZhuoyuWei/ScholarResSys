package com.offline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.po.Item;
import com.po.Paper;


public class PostDBHelper {
	public static Connection getConn() 
    { 
        Connection conn = null; 
        try 
        { 
            Class.forName("org.postgresql.Driver"); 
            String url = "jdbc:postgresql://127.0.0.1:5432/kddtask2test"; 
            try 
            { 
                conn = DriverManager.getConnection(url, "Administrator", "123456"); 
            } 
            catch (SQLException e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        catch (ClassNotFoundException e) 
        { 
            e.printStackTrace(); 
        } 
        return conn; 
    } 
	
	public static ResultSet GetSelectResult(Connection conn,String sql)
	{
		try {
			Statement statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<Integer,Paper> GetPapers(Connection conn,String sql) throws SQLException
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
			 indexToPaper.put(index, paper);
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

		 }
		rs.close();
		rs=st.executeQuery("select * from paperauthor");
		count=0;
		while(rs.next())
		{
			count++;
			//if(count>20)
				//break;
			int paperid=rs.getInt(1);
			String author=rs.getString(3);
			Paper paper=indexToPaper.get(paperid);
			if(paper==null)
				continue;
			paper.getAuthorList().add(author);
		}
		st.close();
		return indexToPaper;
		/*Iterator it=indexToPaper.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			Paper paper=(Paper)entry.getValue();
			
		}*/
	}	
	
	public static void InsertRecord(Connection conn,String sql)
	{
		try {
			Statement state=conn.createStatement();
			state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
