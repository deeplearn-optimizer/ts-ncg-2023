package com.deepak.backend.DAO;

import com.deepak.backend.Beans.ViewData;
import com.deepak.backend.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;

import java.util.List;


public class ViewDataDAO {

    public boolean addViewData(ViewData viewData) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            session.save(viewData);
            t.commit();
            return true;
        } catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    public List<ViewData> getCompleteViewData(Long view_id) {
        try(Session session = HibernateUtil.getSession()) {
            String hqlQuery = "FROM ViewData WHERE view_id = :view_id";
            List<ViewData> resultList = session.createQuery(hqlQuery, ViewData.class)
                    .setParameter("view_id", view_id)
                    .getResultList();
            return resultList;
        } catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null;
    }
}
