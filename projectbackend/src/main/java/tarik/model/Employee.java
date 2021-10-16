package tarik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String phNo;
	private String imgUrl;
	private String designation;
	
	
	
	
	
	public Employee() {
		super();
	}







	public Employee(String firstName, String lastName, String emailId, String phNo, String imgUrl, String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phNo = phNo;
		this.imgUrl = imgUrl;
		this.designation = designation;
	}







	public String getDesignation() {
		return designation;
	}







	public void setDesignation(String designation) {
		this.designation = designation;
	}







	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getPhNo() {
		return phNo;
	}




	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}




	public String getImgUrl() {
		return imgUrl;
	}




	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phNo=" + phNo + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
	
	
}
