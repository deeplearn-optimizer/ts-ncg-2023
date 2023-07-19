package com.deepak.backend;

import com.deepak.backend.Beans.View;
import com.deepak.backend.Beans.ViewData;
import com.deepak.backend.DAO.ViewDAO;
import com.deepak.backend.DAO.ViewDataDAO;
import com.deepak.backend.Services.ViewService;
import com.deepak.backend.Services.WorlBankDataDownloader;
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

//		View view = new View();
//		view.setCountry("IN");
//		view.setIndicator("SP.POP.TOTL");
//		view.setStartDate("909");
//		view.setEndDate("100");
//		new ViewService().addViewData(view);
		SpringApplication.run(BackendApplication.class, args);
	}

}
