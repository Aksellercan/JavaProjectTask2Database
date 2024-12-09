package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

// all database actions under this class
public class Databaseactions {
    //global sessionfactory config to use in class
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void SaveData(Smartphone phone){
        // start session named "session"
        Session session = sessionFactory.openSession();
        try{
            // communicate beginning of the action to the database
            session.beginTransaction();
            //use save function of session
            session.save(phone);
            //commit to the changes
            session.getTransaction().commit();
            System.out.println(phone.getName() + " saved!");
        } catch (Exception e){ //incase of error print it out
            e.printStackTrace();
        } finally {
            session.close(); //remember to close the session
        }
    }
    //same as save function
    public ArrayList<Smartphone> FetchData() {
        ArrayList<Smartphone> phonelist = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Smartphone> smartphones = session.createQuery("from Smartphone", Smartphone.class).list(); //pull objects from specified class
            phonelist.addAll(smartphones);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return phonelist; // Return the list of smartphones
    }
    // clear database entries to avoid duplicates
    public void clearSmartphoneTable() {
        Session session = sessionFactory.openSession();
        try {
            // Begin a transaction and delete all rows from the Smartphone table
            session.beginTransaction();
            session.createQuery("DELETE FROM Smartphone").executeUpdate();  // Delete all records
            session.getTransaction().commit();
            System.out.println("Smartphone table cleared.");
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateData(Smartphone phone){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(phone);
        session.getTransaction().commit();
        session.close();
    }

    public void removeData(Smartphone phone){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
    }
    // convert 0 or 1 to operating system names
    public OperatingSystem getOperatingSystemById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Fetch the OperatingSystem from the database based on the id
            OperatingSystem os = session.get(OperatingSystem.class, (long) id);  // Assuming 0 for Android, 1 for iOS

            session.getTransaction().commit();  // Commit the transaction

            return os;  // Return the OperatingSystem object
        } catch (Exception e) {
            System.out.println("Error fetching Operating System with ID: " + id);
            e.printStackTrace();
            return null;  // Return null if there is an error
        }
    }
    // sort by operating system
    public void listPhonesByOS(String osName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Use a query to get smartphones by operating system name
        List<Smartphone> phones = session.createQuery("FROM Smartphone s WHERE s.operatingSystem.name = :osName", Smartphone.class)
                .setParameter("osName", osName)
                .list();

        for (Smartphone phone : phones) {
            //System.out.println(phone.getName() + " - " + phone.getOperatingSystem().getName());
            System.out.println(phone.toString());
        }

        session.getTransaction().commit();
        session.close();
    }
}