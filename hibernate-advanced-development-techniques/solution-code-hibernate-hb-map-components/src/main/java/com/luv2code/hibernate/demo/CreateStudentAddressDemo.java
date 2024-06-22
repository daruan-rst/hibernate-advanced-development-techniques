package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Address;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.spi.LoadedConfig;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;


public class CreateStudentAddressDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Student tempStudent = new Student("John", "Doe", "paul@luv2code.com");

            Address billingAddress = new Address("Some Billing Street", "Some Billing City", "101010");




            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the student and billing address .. ");
            tempStudent.setBillingAddress(billingAddress);
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("I'm done!!!");
        } finally {
            // clean up code
            session.close();
            factory.close();

        }
    }
}
