package org.example.service;

import org.example.model.Category;
import org.example.model.OrderOption;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryService {
    public static List<Category> getCategories(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from Category");
        List<Category> list = q.list();
        session.getTransaction().commit();
        return list;
    }

    public static Category getCategory(String name) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from Category where name='" + name + "'");
        Category category = (Category) q.uniqueResult();
        session.getTransaction().commit();
        return category;
    }
}
