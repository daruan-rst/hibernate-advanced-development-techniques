package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateUserStudentInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Student tempStudent = new Student("John", "Doe", "paul@luv2code.com", "Hibernate");

            Instructor tempInstructor = new Instructor("Mary", "Public", "mary@luv2code.com", 2000.00);


            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the student and instructor.. ");

            session.save(tempStudent);
            session.save(tempInstructor);

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
