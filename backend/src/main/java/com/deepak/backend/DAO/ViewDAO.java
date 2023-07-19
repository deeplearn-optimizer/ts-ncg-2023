package com.deepak.backend.DAO;

import com.deepak.backend.Beans.View;
import com.deepak.backend.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ViewDAO {

    public boolean addView(View View) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            session.save(View);
            t.commit();
            return true;
        } catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    public List<View> getAllViews() {
        try(Session session = HibernateUtil.getSession()) {
            String hqlQuery = "FROM View";
            List<View> resultList = session.createQuery(hqlQuery, View.class)
                    .getResultList();
            return resultList;
        } catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null;
    }


    public List<View> getViewById(Long view_id) {
        try(Session session = HibernateUtil.getSession()) {
            String hqlQuery = "FROM View WHERE view_id = :view_id";
            List<View> resultList = session.createQuery(hqlQuery, View.class)
                    .setParameter("view_id", view_id)
                    .getResultList();
            return resultList;
        } catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null;
    }

    public boolean deleteView(View view){
        try(Session session = HibernateUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.delete(view);
            t.commit();
            return true;
        }catch(HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return false;
        }


    }

}
