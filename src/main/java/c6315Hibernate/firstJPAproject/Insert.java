package c6315Hibernate.firstJPAproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * DAO class to insert data into database
 *
 */
public class Insert
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        Configuration config = new Configuration();//class reads both the entity and config class
        config.configure();//check config.xml file syntax
        //interface , takes metadata and build connection
        SessionFactory factory = config.buildSessionFactory(); 
       //Session -> time period btw start and end.
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Doctor d = new Doctor();
        		
        System.out.println("Enter Doctor Id");
        int id = sc.nextInt();
        d.setId(id); //primary key
        System.out.println("Enter Doctor NAme");
        sc.nextLine();
        String name = sc.nextLine();
        d.setName(name);
        System.out.println("Enter doctor department");
        String depart = sc.nextLine();
        d.setDepartment(depart);
        System.out.println("Enter doctor Experience.");
        int exp = sc.nextInt();
        d.setExperience(exp);
        
        //Saving object 
        session.save(d);
        
        //TCL
        
        //saving data permanently (Commiting to the changes).
        tx.commit();
        
        session.close();
        factory.close();
   }
}
