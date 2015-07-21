package com.actions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.offline.CourseraData;
import com.offline.DlACMData;
import com.offline.tmpmodel.TemCoursera;
import com.opensymphony.xwork2.ActionContext;
import com.po.Item;
import com.po.ItemAndScore;
import com.po.Keyword;
import com.po.Paper;
import com.po.ScholarTweet;
import com.po.ScholarUser;
import com.service.AccountService;
import com.service.ItemService;

public class DataAction {
	
	public String[] stopwords={"a","about","above","across","after","afterwards","again","against","all","almost",
	                           "alone","along","already","also","although","always","am","among","amongst","amoungst",
	                           "amount","an","and","another","any","anyhow","anyone","anything","anyway","anywhere",
	                           "are","around","as","at","back","be","became","because","become","becomes",
	                           "becoming","been","before","beforehand","behind","being","below","beside","besides","between",
	                           "beyond","bill","both","bottom","but","by","call","can","cannot","cant","like",
	                           "co","con","could","couldnt","cry","de","describe","detail","do","want",
	                           "done","down","due","during","each","eg","eight","either","eleven","else",
	                           "elsewhere","empty","enough","etc","even","ever","every","everyone","everything","everywhere",
	                           "except","few","fifteen","fify","fill","find","fire","first","five","for",
	                           "former","formerly","forty","found","four","from","front","full","further","get",
	                           "give","go","had","has","hasnt","have","he","hence","her","here",
	                           "hereafter","hereby","herein","hereupon","hers","herself","him","himself","his","how",
	                           "however","hundred","i","ie","if","in","inc","indeed","interest","into",
	                           "is","it","its","itself","keep","last","latter","latterly","least","less",
	                           "ltd","made","many","may","me","meanwhile","might","mill","mine","more",
	                           "moreover","most","mostly","move","much","must","my","myself","name","namely",
	                           "neither","never","nevertheless","next","nine","no","nobody","none","noone","nor",
	                           "not","nothing","now","nowhere","of","off","often","on","once","one",
	                           "only","onto","or","other","others","otherwise","our","ours","ourselves","out",
	                           "over","own","part","per","perhaps","please","put","rather","re","same",
	                           "see","seem","seemed","seeming","seems","serious","several","she","should","show",
	                           "side","since","sincere","six","sixty","so","some","somehow","someone","something",
	                           "sometime","sometimes","somewhere","still","such","system","take","ten","than","that",
	                           "the","their","them","themselves","then","thence","there","thereafter","thereby","therefore",
	                           "therein","thereupon","these","they","thick","thin","third","this","those","though",
	                           "three","through","throughout","thru","thus","to","together","too","top","toward",
	                           "towards","twelve","twenty","two","un","under","until","up","upon","us",
	                           "very","via","was","we","well","were","what","whatever","when","whence",
	                           "whenever","where","whereafter","whereas","whereby","wherein","whereupon","wherever","whether","which",
	                           "while","whither","who","whoever","whole","whom","whose","why","will","with",
	                           "within","without","would","yet","you","your","yours","yourself","yourselves"};
	
	private ItemService itemService;
	//private ScholarUserService scholarUserService;
	private AccountService accountService;
	

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	public String fnDownloadCourseraData()
	{
		CourseraData cd=new CourseraData();
		String page=cd.ReadHtmlFromFile("E:\\Workspaces\\MyEclipse 10\\coursera英文.txt");
		List<TemCoursera> list=cd.GetSimpleCourseInfoFromHomePage(page);
		System.out.println("list end\t"+list.size());
		cd.DownloadCourseInfoPage(list,this.itemService);

		return "SUC";
	}
	
	public String fnDownloadDlACMData()
	{
		DlACMData dd=new DlACMData();
		String baseUrl="http://dl.acm.org/citation.cfm?id=";
		int count=0;
		int i;
		//System.getProperties().setProperty("http.proxyHost", "58.51.82.199");
		//System.getProperties().setProperty("http.proxyPort", "8080");
		System.out.println("Start:");
		for(i=2484000;i<2484500;i++)
		{
			try{
			String thisurl=baseUrl+i;
			String page=dd.GetOnePage(thisurl, "utf-8");
			Paper paper=dd.BuildOnePaper(page, i+"", thisurl);
			if(paper!=null)
			{
				this.itemService.AddOneItem(paper);
				count++;
			}
			//break;
			Thread.sleep(61000);
		
			}catch(Exception e)
			{
				e.printStackTrace();
				//break;
				continue;
			}
		}
		System.out.println(count+"\t"+i);
		return "SUC";
	}
	
	
	public boolean CheckWord(String tokenWord)
	{
		char[] chars=(tokenWord.toLowerCase()).toCharArray();
		boolean flag=true;
		for(int i=0;i<tokenWord.length();i++)
		{
			if(chars[i]>'z'||chars[i]<'a')
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public String ComputeSimilarItems()
	{
		long start=System.currentTimeMillis();
		List<Item> list=itemService.GetAllItems();
		Set<String> stopwordSet=new HashSet();
		Map<String,Double>[] keywordToScore=new HashMap[list.size()];
		Map<String,Set<Item>> itemMap=new HashMap<String,Set<Item>>();
		Map<String,Double> scoreMap=new HashMap<String,Double>();
		double[][] similarScore=new double[list.size()][list.size()];
		for(int i=0;i<this.stopwords.length;i++)
		{
			stopwordSet.add(this.stopwords[i]);
		}
		for(int i=0;i<list.size();i++)
		{
			keywordToScore[i]=new HashMap<String,Double>();
			Item item=list.get(i);
			if(item.getItemName()!=null)
			{
				String[] ss=item.getItemName().split("[\\s]+");
				for(int j=0;j<ss.length;j++)
				{
					String token=ss[j].toLowerCase();
					if(token.length()>1&&!stopwordSet.contains(token)&&this.CheckWord(token))
					{
						keywordToScore[i].put(token, 3.);
						Set<Item> tempItemList=itemMap.get(token);
						Double tempScore=scoreMap.get(token);
						if(tempItemList==null)
						{
							tempItemList=new HashSet<Item>();
							itemMap.put(token, tempItemList);
							scoreMap.put(token, 3.);
						}
						else
						{
							scoreMap.remove(token);
							tempScore+=3.;
							scoreMap.put(token, tempScore);
						}
						tempItemList.add(item);
					}
				}
			}
			if(item.getMajor()!=null)
			{
				String[] ss=item.getMajor().split("[\\s]+");
				for(int j=0;j<ss.length;j++)
				{
					String token=ss[j].toLowerCase();
					if(token.length()>1&&!stopwordSet.contains(token)&&this.CheckWord(token))
					{
						keywordToScore[i].put(token, 1.);
						Set<Item> tempItemList=itemMap.get(token);
						Double tempScore=scoreMap.get(token);
						if(tempItemList==null)
						{
							tempItemList=new HashSet<Item>();
							itemMap.put(token, tempItemList);
							scoreMap.put(token, 1.);
						}
						else
						{
							scoreMap.remove(token);
							tempScore+=1.;
							scoreMap.put(token, tempScore);
						}
						tempItemList.add(item);
					}
				}				
			}
			for(int j=0;j<item.getTags().size();j++)
			{
				String token=item.getTags().get(j).toLowerCase();
				if(token.length()>1&&!stopwordSet.contains(token)&&this.CheckWord(token))
				{
					keywordToScore[i].put(token, 2.);
					Set<Item> tempItemList=itemMap.get(token);
					Double tempScore=scoreMap.get(token);
					if(tempItemList==null)
					{
						tempItemList=new HashSet<Item>();
						itemMap.put(token, tempItemList);
						scoreMap.put(token, 2.);
					}
					else
					{
						scoreMap.remove(token);
						tempScore+=2.;
						scoreMap.put(token, tempScore);
					}
					tempItemList.add(item);
				}
			}				
		}
		
		
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				Item itemi=list.get(i);
				Item itemj=list.get(j);
				double score=0.;
				Iterator it=keywordToScore[i].entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry=(Map.Entry)it.next();
					String token=(String)entry.getKey();
					Double scorei=(Double)entry.getValue();
					Double scorej=keywordToScore[j].get(token);
					if(scorej!=null)
					{
						score+=scorei*scorej;
					}
				}
				similarScore[i][j]=score;
				similarScore[j][i]=score;
			}
		}
		
		for(int i=0;i<list.size();i++)
		{
			double maxScore=-1.;
			for(int j=0;j<list.size();j++)
			{
				if(i==j)
					continue;
				if(similarScore[i][j]>maxScore)
				{
					maxScore=similarScore[i][j];
				}
			}
			if(maxScore<1e-6)
				continue;
			list.get(i).getSimilarItemSet().clear();
			for(int j=0;j<list.size();j++)
			{
				if(i==j)
					continue;
				if(Math.abs(similarScore[i][j]-maxScore)<1e-6)
					list.get(i).getSimilarItemSet().add(list.get(j));
			}
			itemService.AddOneItem(list.get(i));
		}
		
		
		Iterator it=itemMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			String token=(String)entry.getKey();
			Set<Item> tempItemList=(Set<Item>)entry.getValue();
			Double tempScore=scoreMap.get(token);
			Keyword keyword=new Keyword();
			keyword.setKeywordToken(token);
			keyword.setScore(tempScore);
			keyword.setItemSet(tempItemList);
			itemService.AddOneKeyword(keyword);
		}
		long end=System.currentTimeMillis();
		System.out.println((end-start)+"ms");
		return "SUC";
	}
	
	
	
	public void BuildKeywordList(ScholarUser user,Set<String> stopwordSet)
	{
		user.getKeywordList().clear();
		String major=user.getMajor();
		String[] ssMajor=major.split("[\\s]+");
		Set<String> keywordSet=new HashSet<String>();
		for(int i=0;i<ssMajor.length;i++)
		{
			String token=ssMajor[i];
			if(token.length()>1&&!stopwordSet.contains(token)&&this.CheckWord(token))
			{
				keywordSet.add(token);
			}
		}
		Set<ScholarTweet> tweetSet=user.getTweets();
		System.out.println(user.getUserName()+"\t"+tweetSet.size()+"\t"+user.getTweets().size());
		List<ScholarTweet> tweetList=new ArrayList<ScholarTweet>();
		tweetList.addAll(tweetSet);

		for(int j=0;j<tweetList.size();j++)
		{
			ScholarTweet st=tweetList.get(j);
			String[] ssTweet=st.getContent().split("[\\s]+");
			for(int i=0;i<ssTweet.length;i++)
			{
				String token=(ssTweet[i].replace("[,.?!]", "")).toLowerCase();
				if(token.length()>1&&!stopwordSet.contains(token)&&this.CheckWord(token))
				{
					keywordSet.add(token);
				}				
			}
		}
		user.getKeywordList().addAll(keywordSet);
	}
	
	public List<Item> RecommendByContent(List<String> keyword,int size)
	{
		List<Item> result=new ArrayList<Item>();
		List<ItemAndScore> isList=new ArrayList<ItemAndScore>();
		Map<Integer,ItemAndScore> itemMapToIs=new HashMap<Integer,ItemAndScore>();
		for(int i=0;i<keyword.size();i++)
		{
			String token=keyword.get(i);
			Keyword keywordForItems=itemService.GetKeywordByToken(token);
			if(keywordForItems==null)
				continue;
			Iterator it=keywordForItems.getItemSet().iterator();
			while(it.hasNext())
			{
				Item item=(Item)it.next();
				int itemId=item.getItemId();
				ItemAndScore is=itemMapToIs.get(itemId);
				if(is==null)
				{
					is=new ItemAndScore();
					is.item=item;
					is.score=0;
					itemMapToIs.put(itemId, is);
				}
				is.score+=1./(keywordForItems.getScore()+1);
			}
		}
		Iterator it=itemMapToIs.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			ItemAndScore is=(ItemAndScore)entry.getValue();
			isList.add(is);
		}
		Collections.sort(isList,new ItemAndScore());
		for(int i=0;i<size;i++)
		{
			if(i>=isList.size())
				break;
			result.add(isList.get(i).item);
		}
		return result;
	}
	public List<Item> RecommendByCF(List<Item> itemList, int size)
	{
		List<Item> result=new ArrayList<Item>();
		List<Item>[] listArray=new List[itemList.size()];
		int total=0;
		for(int i=0;i<itemList.size();i++)
		{
			listArray[i]=new ArrayList<Item>();
			listArray[i].addAll(itemList.get(i).getSimilarItemSet());
			total+=listArray[i].size();
		}
		if(size>total)
			size=total;
		int j=0;
		while(result.size()<size)
		{
			for(int i=itemList.size()-1;i>=0;i--)
			{
				if(listArray[i].size()>j)
				{
					result.add(listArray[i].get(j));
				}
			}
			j++;
		}
		return result;		
	}
	
	public String Analyze()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		if(o==null)
		{
			System.out.println("I'm going to LOGIN!");
			return "LOGIN";
		}
		String userName=o.toString();
		ScholarUser user=accountService.GetScholarUserByName(userName);
		if(user==null)
			return "ERR";
		Set<String> stopwordSet=new HashSet<String>();
		for(int i=0;i<this.stopwords.length;i++)
		{
			stopwordSet.add(this.stopwords[i]);
		}
		
		this.BuildKeywordList(user, stopwordSet);
		Set<Item> recommendItem=new HashSet<Item>();
		if(user.getItems()==null||user.getItems().size()<=0)
		{
			List<Item> temp=this.RecommendByContent(user.getKeywordList(), 30);
			for(int i=0;i<temp.size();i++)
			{
				if(!user.getItems().contains(temp.get(i)))
				{
					recommendItem.add(temp.get(i));
				}
			}
		}
		else
		{
			List<Item> items=new ArrayList<Item>();
			items.addAll(user.getItems());
			List<Item> temp=this.RecommendByCF(items, 20);
			
			for(int i=0;i<temp.size();i++)
			{
				if(!user.getItems().contains(temp.get(i)))
				{
					recommendItem.add(temp.get(i));
				}
			}	
			temp=this.RecommendByContent(user.getKeywordList(), 30);
			for(int i=0;i<temp.size();i++)
			{
				if(!user.getItems().contains(temp.get(i)))
				{
					recommendItem.add(temp.get(i));
				}
			}			
		}
		
		//ctx.put("recommendItems", recommendItem);
		accountService.DeleteAllRecForUser(user.getUserId());
		
		user.setRecommendItems(recommendItem);
		accountService.SaveOneUser(user);
		
		return "SUC";
	}
	
	public String Recommend()
	{
		ActionContext ctx=ActionContext.getContext();
		Object o=ctx.getSession().get("userName");
		if(o==null)
		{
			System.out.println("I'm going to LOGIN!");
			return "LOGIN";
		}
		String userName=o.toString();
		ScholarUser user=accountService.GetScholarUserByName(userName);
		if(user==null)
			return "ERR";
		List<Item> list=new ArrayList<Item>();
		list.addAll(user.getRecommendItems());
		ctx.put("itemList", list);
		return "SUC";
	}
	
	
}
