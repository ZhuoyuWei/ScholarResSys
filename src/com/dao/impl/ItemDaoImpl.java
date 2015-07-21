package com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import com.dao.ItemDao;
import com.po.Comment;
import com.po.Item;
import com.po.Keyword;
import com.po.Paper;

public class ItemDaoImpl implements ItemDao {
	
	private HibernateTransactionManager transactionManager;
	private int itemPageSize=16;
	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public List getItemByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean saveOneItem(Item item) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(item);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Item GetItemByItemId(int itemId) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (Item)s.get(Item.class, itemId);
	}

	@Override
	public boolean addOneComment(Comment com) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(com);
			com.getItem().getComments().add(com);
			s.saveOrUpdate(com.getItem());
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public List getCommentsByItem(Item item) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return s.createQuery("from Comment c where c.item = :item order by c.createTime desc").setEntity("item", item).list();
		//return null;
	}

	@Override
	public Paper getPaperByKddIndex(int kddIndex) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (Paper)s.createQuery("from Paper p where p.kddIndex=:kddindex")
				.setInteger("kddindex", kddIndex).uniqueResult();
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		
		return (List<Item>)s.createQuery("from Item i").list();
	}

	@Override
	public List<Item> getAllItems(int pageIndex) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		
		return (List<Item>)s.createQuery("from Item i order by i.itemId desc")
				.setFirstResult(pageIndex*this.itemPageSize).setMaxResults(this.itemPageSize).list();
	}

	@Override
	public int getAllItemCount() {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();		
		return Integer.parseInt(s.createSQLQuery("select count(*) from item").uniqueResult().toString());
	}

	@Override
	public boolean saveOneKeyword(Keyword keyword) {
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(keyword);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Keyword getKeywordByToken(String token) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (Keyword)s.createQuery(
				"from Keyword k where k.keywordToken=:token").setString("token", token).uniqueResult();
	}
	
	
}
