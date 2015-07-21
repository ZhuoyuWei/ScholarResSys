package org.crazyit.app.dao;

import java.util.List;

import org.crazyit.app.domain.*;
import org.springframework.orm.hibernate4.SpringSessionContext;

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
public interface PersonDao 
{
	/**
	 * ����Personʵ��
	 * @param id ��Ҫ���ص�Personʵ�������ֵ
	 * @return ���ؼ��ص�Personʵ��
	 */ 
	Person get(Integer id);
	 
	/**
	 * ����Personʵ��
	 * @param person ��Ҫ�����Personʵ��
	 * @return �ոձ����Personʵ��ı�ʶ����ֵ
	 */	
	void save(Person person);
	 
	/**
	 * �޸�Personʵ��
	 * @param person ��Ҫ�޸ĵ�Personʵ��
	 */
	void update(Person person);
	
	/**
	 * ɾ��Personʵ��
	 * @param id ��Ҫɾ���Personʵ��ı�ʶ����ֵ
	 */
	void delete(Integer id);
	
	/**
	 * ɾ��Personʵ��
	 * @param person ��Ҫɾ���Personʵ��
	 */
	void delete(Person person);
	
	/**
	 * ����û������Person
	 * @param name ��ѯ������
	 * @return ָ���û����Ӧ��ȫ��Person
	 */
	List<Person> findByName(String name);
	
	/**
	 * ��ѯȫ��Personʵ��
	 * @return ȫ��Personʵ��
	 */
	public List findAllPerson();
	
	/**
	 * ��ѯ��ݱ���Personʵ�������
	 * @return ��ݱ���Personʵ�������
	 */
	long getPersonNumber();
}