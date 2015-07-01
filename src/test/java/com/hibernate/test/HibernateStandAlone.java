package com.hibernate.test;


import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;

import com.ua.entity.Customer;


public class HibernateStandAlone {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

	
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = new Customer();
		
		customer.setActive((byte)1);
		customer.setAddressId(5);
		customer.setCreateDate(new Date());
		customer.setEmail("hnair@gmail.com");
		customer.setFirstName("Hari");
		customer.setLastName("Nair");
		customer.setStoreId((byte)2);
		customer.setLastUpdate(new Timestamp(new Date().getTime()));
		
		session.persist(customer);
		
		
		session.getTransaction().commit();
		session.close();  
	}

}
