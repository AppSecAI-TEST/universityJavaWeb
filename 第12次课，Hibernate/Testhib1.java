package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.TblUser;
import com.hib.HibernateSessionFactory;

public class Testhib1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tx = null;
        try{
 		tx = session.beginTransaction();// 4����ʼһ������
 		// 5���־û�����
 		TblUser user=new TblUser();
 		user.setUserName("������01");
 		user.setUserSex("��");
 		user.setUserSkill("�����");
 		session.save(user);
 		tx.commit();// 6�� �ύ����      
         }catch(Exception e){
		if (null!=tx){tx.rollback();}
 		e.printStackTrace();      
         }finally{
        	 HibernateSessionFactory.closeSession();
         }

	}

}
