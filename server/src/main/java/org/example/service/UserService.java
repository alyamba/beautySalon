package org.example.service;

import org.example.model.UserEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
    public static void add(UserEntity userEntity){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.save(userEntity);

        session.getTransaction().commit();
        session.close();

    }

    public static List<UserEntity> getAllUsers() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from user");
        List<UserEntity> users = q.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public static UserEntity getUserByLogin(String login) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query q = session.createQuery("from user where login = '" + login +"'");
        UserEntity userEntity = (UserEntity) q.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }
}
