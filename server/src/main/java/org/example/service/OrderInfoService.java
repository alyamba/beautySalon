package org.example.service;

import org.example.model.OrderInfo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderInfoService {
    public static void add(OrderInfo orderInfo){
        Session session = HibernateUtil.getSession();

        try{
            session.getTransaction().begin();
            session.save(orderInfo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static List<Object[]> getOrderInfo(String login){
        Session session = HibernateUtil.getSession();

        List<Object[]> list = null;
        try{
            session.getTransaction().begin();
            Query q = session.createQuery("from OrderInfo o inner join o.user u inner join o.orderOptions i inner join i.selection where u.login = '" + login + "'");

            list = q.list();
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }
}
