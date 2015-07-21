package com.offline;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.po.Paper;

public class DlACMData {

	public String GetOnePage(String url,String encode)
	{
		return HtmlParser.getHtmlContent(url, encode);
	}
	
	 public String trim(String source, char c){

	        String beTrim = String.valueOf(c);
	        source = source.trim(); // 循环去掉字符串首的beTrim字符 

	        String beginChar = source.substring(0, 1);  
	        while (beginChar.equalsIgnoreCase(beTrim)) {  
	            source = source.substring(1, source.length());  
	            beginChar = source.substring(0, 1);  
	        }  
	  
	       // 循环去掉字符串尾的beTrim字符  
	       String endChar = source.substring(source.length() - 1, source.length());  
	       while (endChar.equalsIgnoreCase(beTrim)) {  
	            source = source.substring(0, source.length() - 1);  
	            endChar = source.substring(source.length() - 1, source.length());  
	       }  
	       return source;
	 }
	
	public Paper BuildOnePaper(String page,String id,String pageurl)
	{
		Paper paper=new Paper();
		paper.setItemType("paper");
		String psTitle="<title>(.*?)</title>";
		Pattern pTitle=Pattern.compile(psTitle);
		Matcher matcherTitle=pTitle.matcher(page);
		String paperName=null;
		if(matcherTitle.find())
		{
			paperName=matcherTitle.group(1);
		}
		paper.setItemName(paperName);
		if(paper.getItemName().equals("Citation"))
			return null;
		System.out.println("Title:\t"+paperName);
		
		String psAuthors="<table style=\"margin-top: 10px; border-collapse:collapse; padding:2px;\" class=\"medium-text\">(.*?)</table>";
		Pattern pAuthors=Pattern.compile(psAuthors);
		Matcher matcherAuthors=pAuthors.matcher(page);
		
		if(matcherAuthors.find())
		{
			System.out.print("Authors:");
			String authors=matcherAuthors.group(1);
			String psOneAuthor="title=\"Author Profile Page\" target=\"_self\">(.*?)</a>";
			Pattern pOneAuthor=Pattern.compile(psOneAuthor);
			Matcher matcherOneAuthor=pOneAuthor.matcher(authors);
			while(matcherOneAuthor.find())
			{
				String authorName=matcherOneAuthor.group(1);
				paper.getAuthorList().add(authorName);
				System.out.print("\t"+authorName);
			}
			System.out.println();
		}
		
		String psTags="<div id=\"divtags\".*?</div>";
		Pattern pTags=Pattern.compile(psTags);
		Matcher matcherTags=pTags.matcher(page);
		if(matcherTags.find())
		{
			System.out.print("Tags:");
			String divTags=matcherTags.group();
			String psTag="<span class=\"small-text\"(.*?)>(.*?)</span>";
			Pattern pTag=Pattern.compile(psTag);
			Matcher matcherTag=pTag.matcher(divTags);
			int temp=0;
			while(matcherTag.find())
			{
				String tag=matcherTag.group(2);
				String[] ss=tag.split("[\\s]+");
				for(int i=0;i<ss.length;i++)
				{
					if(ss[i].length()>0)
					{
						paper.getTags().add(ss[i]);
						System.out.print(ss[i]+"\t");
						temp++;
					}
				}
			}
			System.out.println(temp);
		}
		
		/*String psTag="<span class=\"small-text\"(.*?)>(.*?)</span>";
		Pattern pTag=Pattern.compile(psTag);
		Matcher matcherTag=pTag.matcher(page);
		System.out.print("Tags:");
		while(matcherTag.find())
		{
			String tag=matcherTag.group(2);
			paper.getTags().add(tag);
			System.out.println(tag+"\t");
		}
		System.out.println();*/
		
		


		String abstrDiv=GetOnePage("http://dl.acm.org/tab_abstract.cfm?id="+id,"utf-8");
		String psAbstr="<p>(.*?)</p>";
		Pattern pAbstr=Pattern.compile(psAbstr);
		Matcher matcherAbstr=pAbstr.matcher(abstrDiv);
		if(matcherAbstr.find())
		{
			String abstr=matcherAbstr.group(1);
			paper.setAbstractContent(abstr);
			System.out.println(abstr);
		}

		String psYear="(\\d{4}) Article";
		Pattern pYear=Pattern.compile(psYear);
		Matcher matcherYear=pYear.matcher(page);
		if(matcherYear.find())
		{
			String yearString=matcherYear.group();
			String[] ss=yearString.split(" ");
			paper.setPubYear(Integer.parseInt(ss[0]));
			System.out.println(ss[0]);
		}
		
		
		
		String psConf="title=\"Conference Website\"  target=\"_self\" class=\"link-text\">(.*?)</a>";
		//String psConf="title=\"Conference Website\" target=\"_self\" class=\"link-text\">(.*?)</a>";
		Pattern pConf=Pattern.compile(psConf);
		Matcher matcherConf=pConf.matcher(page);
		if(matcherConf.find())
		{
			//System.out.println(matcherConf.group());
			String conf=matcherConf.group(1);
			//String[] ss=conf.split("[<>]");
			paper.setPaperType("Conference Paper");
			paper.setConference(conf);
			System.out.println(paper.getPaperType()+"\t"+paper.getConference());
		}
		else
		{
			String psJournal="<td style=\"padding-left:10px;\">(.*?)<a(.*?)archive</a>";
			Pattern pJournal=Pattern.compile(psJournal);
			Matcher matcherJournal=pJournal.matcher(page);
			if(matcherJournal.find())
			{
				//System.out.println(matcherJournal.group(1));
				String journalName=trim(matcherJournal.group(1),' ');
				System.out.println(journalName);
				//String journalPage=this.GetOnePage(matcherJournal.group(1), "utf-8");
				//String psJournalTitle="<title>(.*?)</title>";
				//Pattern pJournalTitle=Pattern.compile(psJournalTitle);
				//Matcher matcherJournalTitle=pJournalTitle.matcher(journalPage);
				if(journalName.length()>0)
				{
					String journal=journalName;
					paper.setPaperType("Journal Paper");
					paper.setJournal(journal);
					System.out.println(paper.getPaperType()+"\t"+paper.getJournal());
				}
			}
			else
			{

			}			
		}
		
		
		

		
		
		paper.setLinkUrl(pageurl);
		
		
		
		return paper;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintStream ps=new PrintStream("dlacm_test1.html");
		DlACMData dd=new DlACMData();
		String page=dd.GetOnePage("http://dl.acm.org/citation.cfm?id=2484100", "utf-8");
		dd.BuildOnePaper(page,"2484100","http://dl.acm.org/citation.cfm?id=2484100");
		ps.print(page);
		ps.close();
	}
	
}
