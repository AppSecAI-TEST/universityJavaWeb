package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.TblUser;

public class TestHib {

	/**
	 * @param args ctrl+sthif+o
	 */
	public static void main(String[] args) {
        Configuration conf = new Configuration().configure();//1����ȡ�����ļ�
        SessionFactory sf = conf.buildSessionFactory();// 2������SessionFactory
        Session session = sf.openSession();// 3����Session
        Transaction tx = null;
        try{
 		tx = session.beginTransaction();// 4����ʼһ������
 		// 5���־û�����
 		TblUser user=new TblUser();
 		user.setUserName("����");
 		user.setUserSex("��");
 		user.setUserSkill("�����");
 		session.save(user);
 		tx.commit();// 6�� �ύ����      
         }catch(Exception e){
		if (null!=tx){tx.rollback();}
 		e.printStackTrace();      
         }finally{
 		session.close();// 7���ر�Session
         }
	}

}
