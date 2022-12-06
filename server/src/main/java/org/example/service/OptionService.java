package org.example.service;

import org.example.model.Selection;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OptionService {
    public static List<Selection> getAllOptions() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from Selection ");
        List<Selection> selections = q.list();
        session.getTransaction().commit();
        session.close();
        return selections;
    }
}
