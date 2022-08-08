package com.wipro.velocity.ims.model;

import java.nio.charset.StandardCharsets;
//import java.sql.Date;
import java.util.Base64;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="dealer")					//table name changed to customer to   "dealer"
public class Dealer {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
   
    @Column(unique = true)
    private String email;
   
    @Column(name="first_name")
    private String fname;
   
    @Column(name="last_name")
    private String lname;
   
    @Column(name="password")
    private String password;
   
     /*@Column(name="dob")
     private java.util.Date dob;*/
    
    @Column(name="phone")
    private String phoneNo;
    
    @Column(name="address")											//modified
    private String address;		
    
    
	@Column(name="verify")
    private String verify="user";
    //modified
   
    /*
    one-to-one relationship,  between Dealer and address entities.
    Implementing With a Foreign Key in JPA     

    @OneToOne annotation on the related entity field, Address.

    */
    
   /* @OneToOne(mappedBy="dealer",cascade =  CascadeType.ALL)			//modified
    private Address address;*/
    
   

	public Dealer() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();  // encrypt password in database field
        String normalString = password;
        String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8) );
        this.password = encodedString;
	}

	/*public java.util.Date getDob() {
		return dob;
	}

	public void setDob(java.util.Date date) {
		this.dob = date;
	}*/

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;									// added getter and setters for address variable
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}


	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    */
    
}
