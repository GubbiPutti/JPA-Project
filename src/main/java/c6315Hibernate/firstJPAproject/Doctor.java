package c6315Hibernate.firstJPAproject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import org.hibernate.dialect.MySQLDialect;

//entity class or POJO class

@Entity //Doctor table will create
public class Doctor 
{
	@Id //primary key
	private int id;
	private String name; 
	private String department;
	private int Experience;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}

	@Override
	public String toString() 
	{
		return "Doctor id=" + id + "\nname=" + name + "\ndepartment=" + department + "\nExperience=" + Experience
				;
	}
	
	
	
	
	//getter and setters -> prefix set or get
	
}

