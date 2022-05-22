package project.CarWash.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Userdata")
public class Customer {
	@Id
	private int id;
	private String name;
	private long contact;
	private String email;
	private String location;
	private String password;
	boolean pendingSchedule;
	public Customer(int id, String name, long contact,String email, String location, String password, boolean pendingSchedule) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.setLocation(location);
		this.password = password;
		this.pendingSchedule = pendingSchedule;
	}
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public boolean isPendingSchedule() {
		return pendingSchedule;
	}
	public void setPendingSchedule(boolean pendingSchedule) {
		this.pendingSchedule = pendingSchedule;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
