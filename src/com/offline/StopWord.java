package com.offline;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StopWord {
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("C:\\stopword.txt"));
		String buffer=null;
		List<String> words=new ArrayList<String>();
		PrintStream ps=new PrintStream("C:\\stopword2.txt");
		while((buffer=br.readLine())!=null)
		{
			if(buffer.length()<=0)
				continue;
			words.add(buffer);
		}
		ps.print("[");
		for(int i=0;i<words.size();i++)
		{
			ps.print("\""+words.get(i)+"\",");
			if((i+1)%10==0)
				ps.println();
		}
		ps.print("];");
		ps.close();
	}
	
}
