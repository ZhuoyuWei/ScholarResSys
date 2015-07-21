package com.po;

import java.util.Comparator;

public class ItemAndScore implements  Comparator{
	public Item item;
	public double score;
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		ItemAndScore is1=(ItemAndScore)o1;
		ItemAndScore is2=(ItemAndScore)o2;
		if(Math.abs(is1.score-is2.score)<1e-10)
			return 0;
		else if(is1.score>is2.score)
			return -1;
		else
			return 1;
	}
}
