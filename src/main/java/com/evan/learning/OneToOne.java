package com.evan.learning;

import com.evan.learning.hibernate.model.onetoone.Identity;
import com.evan.learning.hibernate.model.onetoone.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToOne {
    public static void main(String[] args) {
        // create session factory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // create session object
        Session session = sessionFactory.openSession();

        // create transaction object
        Transaction transaction = session.beginTransaction();

        List<Person> personList = session.createQuery("from Person", Person.class).list();

        for (Person person : personList) {
            System.out.println(person.getName());
        }

        transaction.commit();
        session.close();
    }
}
