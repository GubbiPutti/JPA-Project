package c6315Hibernate.firstJPAproject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//DAO class to read data

public class Read {
	
	static Configuration conf;
	static SessionFactory factory;
	static Session session;
	
	public void readDoctorById(int id)
	{
		/*
		 * get() -> return null if object is not present.
		 * load() -> throws exception ObjectNotFound if object is not present.
		 * */
		//Doctor d1 = session.load(Doctor.class, 105);
		Doctor d1  = session.get(Doctor.class,id); //return data
		
		System.out.println("-----------------------------------");
		System.out.println("Doctor Details");
		System.out.println(d1);
	}
	
	public void deleteById(int id)
	{
		Doctor d1  = session.get(Doctor.class,id);
		Transaction tr = session.beginTransaction();
		
		/*delete() -> return NullPointerException if object is not exist.
		 *remove() -> return NullPointerException if object is not exist.
		 * 
		 */
		
		String name = d1.getName();
		//session.delete(d1);
		
		session.remove(d1);
		tr.commit();
		System.out.println("Doctor "+name+" is removed.");
	}
	
	public void readAllRecords()
	{
		System.out.println("---------------------------");
		System.out.println("All Doctors Details");
		String hqlQuery = "from Doctor"; 
		//set of data = list
		// convert array data to list -> list()
		
		List<Doctor> data = session.createQuery(hqlQuery,Doctor.class).list();
		//System.out.println(data);
		for(Doctor d : data)
		{
			int i=1;
			System.out.println(" ****Doctor Detail "+ i+"*****");
			System.out.println(d);
			System.out.println("....................................");
			i++;
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Read read = new Read();
		
		//step1
		conf= new Configuration();
		conf.configure();
		//step2
		factory = conf.buildSessionFactory();
		session = factory.openSession();
		
		System.out.println("1.Read Doctor data by ID\n2.Read All doctors data.\n3.Remove Doctor.");
		int choice = sc.nextInt();
		int id;
		switch (choice) {
		case 1: System.out.println("Enter the Doctor id");
				 id = sc.nextInt();
				read.readDoctorById(id);
			
			break;
			
		case 2:read.readAllRecords();
			
			break;
		case 3:System.out.println("Enter the Doctor id");
				id = sc.nextInt();
				read.deleteById(id);

		default: System.out.println("Thank You");
			break;
		}
		
		
		
		
		
	}

}
