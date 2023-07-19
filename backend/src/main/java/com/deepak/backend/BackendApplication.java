package com.deepak.backend;

import com.deepak.backend.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSession()) {
			Transaction transaction = session.beginTransaction();

			transaction.commit();
			System.out.println("Yaayee");
		} catch (HibernateException exception) {
			System.out.print(exception.getLocalizedMessage());
			System.out.println("Nawwwwww");
		}
		SpringApplication.run(BackendApplication.class, args);
	}

}
