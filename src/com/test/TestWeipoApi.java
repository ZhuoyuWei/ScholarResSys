package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.po.ScholarUser;

import weibo4j.Timeline;
import weibo4j.Weibo;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.examples.oauth2.Log; 
public class TestWeipoApi {
    public static void main(String[] args) {  
        /*String access_token = "2.002VohQCGic_eD10cfe1b2bb_NJwLE";  
        String statuses = "试试API";  
        Weibo weibo = new Weibo();  
        weibo.setToken(access_token);  
        Timeline tm = new Timeline();  
        try {  
            Status status = tm.UpdateStatus(statuses);  
            Log.logInfo(status.toString());  
        } catch (WeiboException e) {  
            e.printStackTrace();  
        }   }  */
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ScholarUser su=(ScholarUser)ctx.getBean("testScholarUser");
    	System.out.println(su.getUserName()+"\t"+su.getPassword());
    	
    }
}
