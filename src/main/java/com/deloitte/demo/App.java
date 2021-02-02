package com.deloitte.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Start");

		Configuration config = new Configuration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = new Employee(1, "Sonu", 10.5);

		session.save(emp); // insert
		transaction.commit();

		Employee emp2 = session.get(Employee.class, 1); // select * form emp where id = 1;
		System.out.println(emp2.toString());

		session.close();
		factory.close();

		System.out.println("End");

	}
}

// hibernate configuration - 
// 1. xml based config 
// 2. annotation based config 

// 3. java based cnfig 

// stmt.execute("Select * form employees");

//get(); // select 
//save(); // insert 
//update(); // update
//delete() // delete 
