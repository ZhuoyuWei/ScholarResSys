package org.crazyit.app.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.*;
import org.springframework.orm.hibernate4.support.*;
import org.springframework.transaction.PlatformTransactionManager;

import org.crazyit.app.dao.*;
import org.crazyit.app.domain.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

public class PersonDaoHibernate implements PersonDao
{
	private HibernateTransactionManager transactionManager;



	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * ����Personʵ��
	 * @param id ��Ҫ���ص�Personʵ��ı�ʶ����ֵ
	 * @return ָ��id��Ӧ��Personʵ��
	 */
	public Person get(Integer id)
	{
		
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (Person)s.get(Person.class, id);
		
		//return (Person) getHibernateTemplate()
			//.get(Person.class, id); 
	}
	
	/**
	 * ����Personʵ��
	 * @param person ��Ҫ�����Personʵ��
	 * @return �ոձ����Personʵ��ı�ʶ����ֵ
	 */   
	public void save(Person person)
	{
		//HibernateTemplate ht=getHibernateTemplate();
		//return (Integer)ht.save(person);
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		s.save(person);
	}
	
	/**
	 * �޸�Personʵ��
	 * @param person ��Ҫ�޸ĵ�Personʵ��
	 */
	public void update(Person person)
	{
		//getHibernateTemplate().update(person);
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		s.saveOrUpdate(person);
	}
	
	/**
	 * ɾ��Personʵ��
	 * @param id ��Ҫɾ���Personʵ��ı�ʶ����ֵ
	 */
	public void delete(Integer id)
	{
		//getHibernateTemplate().delete(get(id));
		Person p=get(id);
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		s.delete(p);
		
	}
	
	/**
	 * ɾ��Personʵ��
	 * @param person ��Ҫɾ���Personʵ��
	 */
	public void delete(Person person)
	{
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		s.delete(person);		
	}
	
	/**
	 * ����û������Person
	 * @param name ��ѯ������
	 * @return ָ���û����Ӧ��ȫ��Person
	 */
	public List<Person> findByName(String name)
	{
		Session s=transactionManager.getSessionFactory().getCurrentSession();
		return (List<Person>)s.createQuery("Select p from Person p where p.name = ?")
				.setString(0, name).list();
	}
	
	/**
	 * ��ѯȫ��Personʵ��
	 * @return ȫ��Personʵ��
	 */
	public List findAllPerson()
	{
		Session s=transactionManager.getSessionFactory().getCurrentSession();		
		return (List)s.createQuery("Select p from Person p").list();
	}
	
	/**
	 * ��ѯ��ݱ���Personʵ�������
	 * @return ��ݱ���Personʵ�������
	 */
	public long getPersonNumber()
	{
		Session s=transactionManager.getSessionFactory().getCurrentSession();			
		return (Long)s.createQuery("select count(*) from Person as p").uniqueResult();
	}
}