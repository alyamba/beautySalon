package org.example.service;

import org.example.model.OrderOption;
import org.example.model.Selection;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class SelectionService {
    public static Selection getByName(String name) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query q = session.createQuery("from Selection where name='" + name + "'");
        Selection item = (Selection) q.uniqueResult();
        session.close();
        return item;
    }

    public static void add(Selection selection){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        try {
            session.save(selection);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
