package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class A_AddEmployee {
    public static void main(String[] args) {
        //hello world to add a rec to the db
        //1. get the session factory
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();

        //2. get the session from the session factory
        Session session=sessionFactory.openSession();//openSession() vs getCurrentSession()

        //3. u need to start the tx

        Transaction tx=session.getTransaction();

        try{
            tx.begin();

            Employee employee1=new Employee("ravi",6700,"IT");
            Employee employee2=new Employee("raj",9700,"Training");
            Employee employee3=new Employee("ekta",9710,"Fin");

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            tx.commit();

        }catch (HibernateException e){
            e.printStackTrace();
        }

        session.close();

        sessionFactory.close();



    }
}
