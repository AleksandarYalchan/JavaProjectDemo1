package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;


@Entity
@Table(name="admins")
public class Admin {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="admin_id")
    private int admin_id;
    @Column(name="username")
    private String userName;
    @Column(name="first_name")
    private String First_Name;
    @Column(name="last_name")
    private String Last_Name;

    public Admin() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

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
