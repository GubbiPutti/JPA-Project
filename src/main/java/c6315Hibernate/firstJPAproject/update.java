package c6315Hibernate.firstJPAproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class update 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        Configuration config = new Configuration();//class reads both the entity and config class
        
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        
        Doctor d = session.get(Doctor.class, 112); //return object
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Update the name");
        d.setName("Sudha");
        //session.update(d);
        session.merge(d);
        
        transaction.commit();
        session.close();
        sc.close();
        
	}

}
