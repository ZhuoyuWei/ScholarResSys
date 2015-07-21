package com.offline;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;





import com.offline.tmpmodel.TemCoursera;
import com.po.OnelineCourse;
import com.service.ItemService;

public class CourseraData {

	List<OnelineCourse> courseList=new ArrayList<OnelineCourse>();
	
	public String ReadHtmlFromFile(String filename)
	{
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String buffer=null;
			while((buffer=br.readLine())!=null)
			{
				sb.append(buffer+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public List<TemCoursera> GetSimpleCourseInfoFromHomePage(String page)
	{
		List<TemCoursera> courseList=new ArrayList<TemCoursera>();
		String pattern="<div class=\"coursera-catalog-listing-primary\">.*?</div>";
		Pattern p=Pattern.compile(pattern);
		Matcher match=p.matcher(page);
		int count=0;
		while(match.find())
		{
			count++;
			String oneCourseString=match.group();
			TemCoursera tc=new TemCoursera();
			String pOrganization="<span class=\"coursera-catalog-listing-university\">.*?</span>";
			Pattern p2=Pattern.compile(pOrganization);
			Matcher matcher2=p2.matcher(oneCourseString);
			if(matcher2.find())
			{
				String univercityString=matcher2.group();
				String puni="internal-home\">(.*?)<span";
				Pattern p3=Pattern.compile(puni);
				Matcher matcher3=p3.matcher(univercityString);
				if(matcher3.find())
				{
					tc.orgabization=matcher3.group(1);
				}
			}
			String pCourseName="<span class=\"coursera-catalog-listing-coursename\">.*?</span>";
			p2=Pattern.compile(pCourseName);
			matcher2=p2.matcher(oneCourseString);
			if(matcher2.find())
			{
				String courseString=matcher2.group();
				String purl="<a href=\"(.*?)\"";
				Pattern p3=Pattern.compile(purl);
				Matcher matcher3=p3.matcher(courseString);
				if(matcher3.find())
				{
					tc.url=matcher3.group(1);
				}
				String pname="internal-home\">(.*?)<span";
				p3=Pattern.compile(pname);
				matcher3=p3.matcher(courseString);
				if(matcher3.find())
				{
					tc.courseName=matcher3.group(1);
				}
			}
			String pInstructor="<span class=\"coursera-catalog-listing-instructor\">.*?</div>";
			p2=Pattern.compile(pInstructor);
			matcher2=p2.matcher(oneCourseString);
			if(matcher2.find())
			{
				String instructorString=matcher2.group();
				String pinst="secondary-link\">(.*?)<span";
				Pattern p3=Pattern.compile(pinst);
				Matcher matcher3=p3.matcher(instructorString);
				while(matcher3.find())
				{
					tc.professors.add(matcher3.group(1));
				}
			}
			courseList.add(tc);
		}
		System.out.println("give me five: "+count+"\t"+courseList.size());
		return courseList;
	}
	
	 public String getHtml(String url,String encode){  

	        InputStream in = null;  
	        ByteArrayOutputStream bos = null;  
	            URL u;
				try {
					u = new URL(url);
				
	            HttpURLConnection httpConn = (HttpURLConnection) u.openConnection();  
	            // 设置user agent确保系统与浏览器版本兼容  
	            HttpURLConnection.setFollowRedirects(true);  
	            httpConn.setRequestMethod("POST");   
	            httpConn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64)" +
	            		" Chrome/31.0.1650.63 ");  
	            in = u.openStream();  
	            // 设置连接主机超时（单位：毫秒）  
	            httpConn.setConnectTimeout(100000);  
	            // 设置从主机读取数据超时（单位：毫秒）   
	            httpConn.setReadTimeout(30000);   
	            int length = 0;  
	            bos = new ByteArrayOutputStream();   
	            while((length = in.read()) != -1) {   
	                 bos.write(length);  
	                 bos.flush();  
	            }  
	            in.close();  
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	           try {
				return new String(bos.toByteArray(),encode);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	           return null;
	    }  
	
	public String getPageSource(String pageUrl,String encoding) {  
        StringBuffer sb = new StringBuffer();  
        try {  
            //构建一URL对象  
            URL url = new URL(pageUrl);  
            //使用openStream得到一输入流并由此构造一个BufferedReader对象  
            BufferedReader in = new BufferedReader(new InputStreamReader(url  
                    .openStream(), encoding));  
            String line;  
            //读取www资源  
            while ((line = in.readLine()) != null) {  
                sb.append(line);  
                sb.append("\n");
            }  
            in.close();  
        } catch (Exception ex) {  
            System.err.println(ex);  
        }  
        return sb.toString();  
    } 
	
	public void DownloadCourseInfoPage(List<TemCoursera> list,ItemService itemService)
	{
		int count=0;
		for(int i=0;i<list.size();i++)
		{
			
			try{
			TemCoursera tc=list.get(i);
			OnelineCourse oc=new OnelineCourse();
			oc.setItemName(tc.courseName);
			oc.setItemType("online");
			oc.setLinkUrl("https://www.coursera.org"+tc.url);
			oc.setAuthorList(tc.professors);
			String[] ss=tc.url.split("/");
			System.out.println(i+"\t"+tc.courseName+" is start");
			String courseUrl="https://www.coursera.org/maestro/api/topic/information?topic-id="+ss[ss.length-1];
			String pageContent=getPageSource(courseUrl,"utf-8");
			this.directGet(pageContent, oc);
			this.courseList.add(oc);
			itemService.AddOneItem(oc);
			System.out.println(i+"\t"+tc.courseName+" is end");
			count++;
			}catch(Exception e)
			{
				e.printStackTrace();
				//break;
			}

			
		}
		System.out.println("Finally, "+count+" are successful");
	}
	
	public void PrintJson(String dirName)
	{
		for(int i=0;i<this.courseList.size();i++)
		{
			OnelineCourse oc=this.courseList.get(i);
			try {
				PrintStream ps=new PrintStream(dirName+i+".course");
				ps.print("{");
				ps.print("\"ItemName\":\""+oc.getItemName()+"\",");
				ps.print("\"Major\":\""+oc.getMajor()+"\",");	
				ps.print("\"LinkUrl\":\""+oc.getLinkUrl()+"\",");	
				ps.print("\"Content\":\""+oc.getContent()+"\",");	
				ps.print("\"ImageUrl\":\""+oc.getImageUrl()+"\",");	
				ps.print("\"Short_des\":\""+oc.getShort_des()+"\",");
				ps.print("\"AuthorList\":");
				ps.print("[");
				for(int j=0;j<oc.getAuthorList().size();j++)
				{
					ps.print("{\"author\":\""+oc.getAuthorList().get(j)+"\"}");
					if(j<oc.getAuthorList().size()-1)
						ps.print(",");
				}
				ps.print("]");
				ps.print("}");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ParsingOneCourse(String filename)
	{
		//StringBuilder sb=new StringBuilder();
		String json=null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(filename));
			//String buffer=null;
			/*while((buffer=br.readLine())!=null)
			{
				sb.append(buffer);
				sb.append("\n");
			}*/
			json=br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSONObject jsonObject=JSONObject.fromObject(json);
		//Object bean=JSONObject.toBean(jsonObject);
		//String name=jsonObject.get("name").toString();
		//System.out.println(name);
		
		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = null;
		
		objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            //List<LinkedHashMap<String, Object>> list = objectMapper.readValue(json, List.class);
            //System.out.println(list.size());
            Map<String,Object> map=objectMapper.readValue(json, Map.class);
            String name=map.get("short_description").toString();
            System.out.println(name);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
	}
	
	public void directGet(String json,OnelineCourse oc)
	{
		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = null;
		
		objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            
            //System.out.println(list.size());
            Map<String,Object> map=objectMapper.readValue(json, Map.class);
            String short_des=map.get("short_description").toString();
            oc.setShort_des(short_des);
            String content=map.get("about_the_course").toString();
            oc.setContent(content);
            String imageUrl=map.get("photo").toString();
            oc.setImageUrl(imageUrl);
            
           // String jsonCategories=map.get("categories").toString();
           // System.out.println(jsonCategories);
            String major="";
           // List<LinkedHashMap<String, Object>> list = objectMapper.readValue(jsonCategories, List.class);
            List<LinkedHashMap<String, Object>> list=(List<LinkedHashMap<String, Object>>)map.get("categories");
            for(int i=0;i<list.size();i++)
            {
            	Map<String,Object> map2=list.get(i);
            	major+=map2.get("name").toString()+" ";
            }
            oc.setMajor(major);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		/*CourseraData cd=new CourseraData();
		String page=cd.ReadHtmlFromFile("E:\\Workspaces\\MyEclipse 10\\coursera英文.txt");
		List<TemCoursera> list=cd.GetSimpleCourseInfoFromHomePage(page);
		PrintStream ps=new PrintStream("coursera.info");
		for(int i=0;i<list.size();i++)
		{
			TemCoursera tc=list.get(i);
			ps.print(tc.courseName+"\t"+tc.orgabization+"\t"+tc.url);
			for(int j=0;j<tc.professors.size();j++)
			{
				ps.print("\t"+tc.professors.get(j));
			}
			ps.println();
		}
		ps.close();
		cd.DownloadCourseInfoPage(list);
		cd.PrintJson("courseJson\\");*/
		//String s=cd.getHtml("https://www.coursera.org/", "utf-8");
		//System.out.println(s);
		/*cd.ParsingOneCourse("E:\\Workspaces\\MyEclipse 10\\ScholarResSys" +
				"\\courseraPages\\Algorithms, Part I.txt");*/
		
	}
	
}
