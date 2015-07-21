package com.offline;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;





public class HtmlParser {
	
	public static Map<String,String> headerInfo=new HashMap<String,String>();
	
	
	public static String getHtmlContent(URL url, String encode) {
		StringBuffer contentBuffer = new StringBuffer();

		int responseCode = -1;
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			/*con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");// IE代理进行下载
			
			Iterator it=headerInfo.entrySet().iterator();
			System.out.println(headerInfo.size());
			while(it.hasNext())
			{
				Map.Entry entry=(Map.Entry)it.next();
				con.setRequestProperty(entry.getKey().toString(), entry.getValue().toString());
			}
			con.setRequestProperty("connection","keep-alive");
			con.setRequestProperty("cache-control","max-age=0");
			con.setRequestProperty("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8");
			con.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");			
			con.setRequestProperty("accept-encoding","deflate,sdch");
			con.setRequestProperty("accept-language","zh-CN,zh;q=0.8,en;q=0.6");			
			con.setRequestProperty("ra-ver","1.4.6");
			con.setRequestProperty("ra-sid","9FE2B120-20131210-084740-f9b6da-15e889");*/
			
			con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			con.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
			con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");	
			con.setRequestProperty("Connection", "keep-alive");		
			con.setRequestProperty("Cookie", "__204u=7851708573-1382633874459; __204r=http%3A%2F%2Fwww.google.com%2Furl%3Fsa%3Dt%26rct%3Dj%26q%3Dcoursera%26source%3Dweb%26cd%3D1%26ved%3D0CCkQFjAA%26url%3D%2568%2574%2574%2570%2573%253a%252f%252f%2577%2577%2577%252e%2563%256f%2575%2572%2573%2565%2572%2561%252e%256f%2572%2567%252f%26ei%3DalFpUszOEMb6iQfUqYGAAw%26usg%3DAFQjCNEAm-45Muq_nX5INW96szY5GEJGUg%26bvm%3Dbv.55123115%2Cd.aGc%26cad%3Drjt; __204r=https%3A%2F%2Fwww.coursera.org%2Fcourses; maestro_login_flag=1; CAUTH=58jJiCXcWMmsbR2NVdZEfc3nuVyUaidCD59oqlvo3rfRP2eSBwVNTSx7DUWr-F8pl5ZnqmNfvH6gTBmGieffAQ.fOB9mJ0lv7T67OBN4kkF_w.E8E-0b17767WmgoctZ8EoN-bnGnSYv2aNeegDJUlSBshSFY-lea6rt-XecDzuRXhTpr0Zfofr-UknGBw3Y1GOz1lf-UqO4y7Ou8Nc-ZCFn_KOLoDI8uUDbm5nZ22I3ZbH8qPBZ9AU9sMVQ87Bwep5br4rdGZ9nADBeXB-v8HOck; ab-experiments-user=homepage-nux-button%2Cimprove_list_my3; data-readme-i18n-announcement=1; maestro_login_flag=1; maestro_login=\"5S0qa61+tgWKdS7PVFs3BQ0tViOUJzrfbkYmFEbbpc8/aKpTkZVQMgwyyeF5elBkmXng1LnQFy+mUiMbkSfr+g==|mRCAxgo374DL1N6yNRkDOh6Zony+s8InBTugfXb/ovsN45Xh+lwH4FSGzMfrT5pCjIkqpszHBdE0wvl7cxnBbSfXqCsoJpdRemMSOwpoK6SeHC5W/sBwVom7Pb5GVld+DI66qis+8sXRVgdGEy25rhwxWGHmyHRo6HKssBbF8jNoEuj9+p1WiBLG4MZMpa0nYpsd5C2Ujd17p3ExEUYDWM/0qTD1uj35pg7vXVPyVaaBoEANKLK2HFp1PQhI6eJE7pACTTskmMasRQrm6lAXJWU9dxnwK/MgmXx5LFCOeTAvtXSWCONNgLCZxSH1NYG17hH+jzq2A48w2FY9Y9Pg4Fal345yHay+Dzu879QCuaa3BqEYYBfrXJy7/3VReaT8V9hI5ilyJmsXRcqdupMQv4ANLzbX0yMc1ake6nlvkB/ft3TsQmUiGQJXi8p115WrMfHOSBFIoqPtdjc4mXvCogUicfJm8SxZ2Py7Oz2lDTo=\"; ab-experiments-session=homepage_banner_size2%2Chomepage_browse_all_placement2%2Chomepage_course_count2%2Chomepage_sort_course_3%2Ccoursepage_compress_language%2Ccoursepage_metadata%2Ccoursepage_earn_verified_certificate%2Ccoursepage_sigtrack_flip_order%2Ccoursepage_flat_buttons2%2Ccoursecatalog_inline_enroll2%2Csigtrack_course_catalog_sigtrack_label2%2Cexp_show_st_cert%2Csigtrack_modal_button; recently_viewed=introastro%2Cnanotech; __utma=158142248.734143379.1382633876.1386825854.1386825854.8; __utmc=158142248; __utmz=158142248.1386418438.5.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)");				
			con.setRequestProperty("Host","www.coursera.org");
			con.setRequestProperty("RA-Sid","9FE2B120-20131210-084740-f9b6da-15e889");	
			con.setRequestProperty("RA-Ver","1.4.6");
			con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");				
			con.setRequestProperty("Cache-Control","max-age=0");			
			
			//con.setConnectTimeout(60000);
			//con.setReadTimeout(60000);
			// 获得网页返回信息码
			
			
			responseCode = con.getResponseCode();
			if (responseCode == -1) {
				System.out.println(url.toString() + " : connection is failure...");
				con.disconnect();
				return null;
			}
			if (responseCode >= 400) // 请求失败
			{
				System.out.println("请求失败:get response code: " + responseCode);
				con.disconnect();
				return null;
			}

			
			InputStream urlStream = con.getInputStream();
			//InputStream urlStream = new GZIPInputStream(con.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream,"utf-8"));
			String line = "";
			while((line = reader.readLine()) != null) {
				contentBuffer.append(line);
			}
			
			urlStream.close();
			reader.close();
			
			/*InputStream inStr = con.getInputStream();
			InputStreamReader istreamReader = new InputStreamReader(inStr, encode);
			BufferedReader buffStr = new BufferedReader(istreamReader);

			String str = null;
			while ((str = buffStr.readLine()) != null)
				contentBuffer.append(str);
			inStr.close();*/
		} catch (IOException e) {
			e.printStackTrace();
			contentBuffer = null;
			System.out.println("error: " + url.toString());
			return null;
		} finally {
			con.disconnect();
		}
		return contentBuffer.toString();
	}

	public static String getHtmlContent(String url, String encode) {
		if (!url.toLowerCase().startsWith("http://")) {
			//url = "http://" + url;
		}
		try {
			URL rUrl = new URL(url);
			return getHtmlContent(rUrl, encode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String argsp[]) throws FileNotFoundException{
		String content=getHtmlContent("https://www.coursera.org/maestro/api/topic/information?topic-id=biostats","gb2312");
		PrintStream psTest=new PrintStream("test2.html");
		psTest.println(content);
		
	}
}
