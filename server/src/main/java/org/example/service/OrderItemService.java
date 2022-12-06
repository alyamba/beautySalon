package org.example.service;

import org.example.model.OrderInfo;
import org.example.model.OrderOption;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderItemService {
    public static void add(OrderOption orderedOption){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        try {
            session.save(orderedOption);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<OrderOption> getOrderedItem(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from OrderOption");
        List<OrderOption> list = q.list();
        session.getTransaction().commit();
        return list;
    }
}
