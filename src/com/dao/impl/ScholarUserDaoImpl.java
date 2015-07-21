package com.dao.impl;

import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import weibo4j.http.AccessToken;
import weibo4j.model.User;

import com.dao.ScholarUserDao;
import com.po.Item;
import com.po.ScholarUser;

public class ScholarUserDaoImpl implements ScholarUserDao{
	private HibernateTransactionManager transactionManager;
	private int userPageSize=9;
	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public ScholarUser getScholarUserByName(String userName) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		ScholarUser u=(ScholarUser)s.createQuery("select u from ScholarUser u where u.userName = ?")
				.setString(0, userName).uniqueResult();
		/*if(u==null)
		{
			System.out.println("u is null");
		}
		else
		{
			System.out.println("not null");
			System.out.println(u.getUserId());
		}*/
		return u;
	}
	
	@Override
	public ScholarUser getScholarUserById(int userId) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		ScholarUser u=(ScholarUser)s.createQuery("select u from ScholarUser u where u.userId = ?")
				.setInteger(0, userId).uniqueResult();

		return u;
	}

	@Override
	public ScholarUser getScholarUserByNameAndPassword(String userName,
			String password) {
		// TODO Auto-generated method stub

		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (ScholarUser)s.createQuery("from ScholarUser as u where u.userName=:userName and u.password=:password")
				.setString("userName", userName).setString("password", password).uniqueResult();

	}

	@Override
	public boolean saveOneUser(ScholarUser user) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(user);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addOneItemForUser(ScholarUser user, Item item) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			//s.load(user.getUserId(), user.getClass());
			user.getItems().add(item);
			/*System.out.println(user.getItems().size());
			java.util.Iterator it=user.getItems().iterator();
			while(it.hasNext())
			{
				System.out.println(((Item)it.next()).getItemName());
			}*/
			s.saveOrUpdate(user);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public ScholarUser getScholarUserByNameWithItems(String userName) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		ScholarUser u=(ScholarUser)s.createQuery("from ScholarUser u where u.userName = ?")
				.setString(0, userName).uniqueResult();
		/*List l=s.createQuery("select i from Item i,ScholarUser u inner join u.items where u.userId = :userId")
				.setInteger("userId", u.getUserId()).list();
		for(int i=0;i<l.size();i++)
		{
			u.getItems().add((Item)l.get(i));
		}*/
	
		return u;
	}

	@Override
	public boolean addOneUserForUser(ScholarUser sourceUser,
			ScholarUser targetUser) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			sourceUser.getFriends().add(targetUser);
			s.saveOrUpdate(sourceUser);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addOneSinaUser(User user) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(user);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean addScholarUserSinaInfo(ScholarUser scholarUser, User sinaUser) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			//scholarUser.setSinaUid(sinaUser.getId());
			scholarUser.setWeiboScreenName(sinaUser.getScreenName());
			s.saveOrUpdate(scholarUser);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean addSinaFriends(User user,String[] friendIds) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			int l=friendIds.length;
			for(int i=0;i<l;i++)
			{
				user.getFriendsIdList().add(friendIds[i]);
			}
			s.saveOrUpdate(user);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}		
		return true;		
	}

	@Override
	public List getScholarFriendsForSina(ScholarUser scholarUser) {
		// TODO Auto-generated method stub
		
		String uid=scholarUser.getAccessToken().getUid();
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		//s.createQuery("from ScholarUser s inner join User.friendsIdList uf with s.sinaUid=f.friendid");
		
		return s.createSQLQuery("select s.* from scholaruser s where s.accessToken " +
				"in (select suf.friendid from sina_user_friend suf where suf.uid=?)")
				.addEntity(ScholarUser.class).setString(0, uid).list();
		
		//return null;
	}

	@Override
	public boolean addSeveralFriendsForUser(ScholarUser sourceUser, List list) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			for(int i=0;i<list.size();i++)
			{
				sourceUser.getFriends().add((ScholarUser)list.get(i));
			}
			s.saveOrUpdate(sourceUser);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}		
		return true;	
	}

	@Override
	public AccessToken getAccessTokenByUserName(String userName) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		if(s==null)
		{
			System.out.println("s is null");			
		}
		System.out.println(userName);
		Object o=s.createQuery("select a from ScholarUser s inner join s.accessToken a where s.userName=:userName")
			.setString("userName", userName).uniqueResult();
		
		if(o==null)
		{
			System.out.println("In GetAccessTokenByUserName, the result is null.");
			return null;
		}
		else
		{
			return (AccessToken)o;
		}
		

	}

	@Override
	public boolean saveAccessTokenForScholarUser(ScholarUser user,
			AccessToken accessToken) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			//s.saveOrUpdate(accessToken);
			user.setAccessToken(accessToken);
			s.saveOrUpdate(user);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}		
		return true;	
	}

	@Override
	public List<ScholarUser> getAllUsers(int pageIndex) {
		// TODO Auto-generated method stub
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (List<ScholarUser>)s.createQuery("from ScholarUser s order by s.userId desc")
				.setFirstResult(pageIndex*this.userPageSize).setMaxResults(this.userPageSize).list();

	}

	@Override
	public int getTotalUserNum() {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();		
		return Integer.parseInt(s.createSQLQuery("select count(*) from scholaruser").uniqueResult().toString());
	}

	@Override
	public void delRecommendByUserId(int userId) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		s.createSQLQuery("delete from user_recommend where userid=?").setInteger(0, userId).executeUpdate();
	}




	
}
