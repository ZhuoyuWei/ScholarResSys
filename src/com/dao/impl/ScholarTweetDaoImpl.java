package com.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import com.dao.ScholarTweetDao;
import com.po.ScholarTweet;
import com.po.ScholarUser;

public class ScholarTweetDaoImpl implements ScholarTweetDao {
	private HibernateTransactionManager transactionManager;

	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public List getTweetByUser(ScholarUser user) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return s.createQuery("from ScholarTweet st where createby=:createby")
				.setEntity("createby", user).list();
	}

	@Override
	public List getTweetByUser(ScholarUser user, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return s.createQuery("from ScholarTweet st where createby=:createby")
				.setEntity("createby", user).setFirstResult(pageIndex*pageSize+1)
				.setMaxResults(pageSize).list();		
	}

	@Override
	public List getFriendsTweetByUser(ScholarUser user) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();	
		/*s.createQuery("select t from ScholarUser f inner join f.tweets where f in" +
				" (from ScholarUser u.friends where u.userName=:userName)");*/
		/*return s.createQuery("from st where st.createby in " +
				"(from ScholarUser u inner join u.friends f where u=:user)")
				.setEntity("user", user).list();	*/
		/*return s.createQuery("select st from ScholarTweet st,ScholarUser u inner join ScholarUser u1 inner join" +
				" ScholarUser where u=:user")
				.setEntity("user", user).list();*/
		return	s.createSQLQuery("select st.* from scholartweet st where st.userid in " +
				"(select uu.elt from user_user uu where uu.userid = ?) order by st.tweetId desc").addEntity(ScholarTweet.class)
				.setInteger(0, user.getUserId()).list();
		
	}

	@Override
	public List getFriendsTweetByUser(ScholarUser user, int pageIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOneTweet(ScholarTweet tweet) {
		// TODO Auto-generated method stub
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		try{
			s.saveOrUpdate(tweet);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}




	
	
}
