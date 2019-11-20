package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Admin {

    /*
    public static void CreateStorageUnitOwner(StorageUnitOwner newOwner) {
        try {
            SessionFactory factory;
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            session.save(newOwner);
            t.commit();
            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void CreateStorageUnitAgent(StorageUnitAgent newAgent) {

                     try {
            SessionFactory factory;
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            session.save(newAgent);
            t.commit();
            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }*/

     public static <T>void CreateStorageUnitUserOrUnit(T newUser){
        try {
            SessionFactory factory;
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            session.save(newUser);
            t.commit();
            session.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

}
