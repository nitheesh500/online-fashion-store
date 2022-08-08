package com.wipro.velocity.ims.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.ims.model.Dealer;

public interface UserRepository extends CrudRepository<Dealer, Long> {

	// Fetch record/object based on email - non Id field
	//this is a custom repository method  for which implementation will be created at runtime. Creates based on the name of the method.
    public Dealer findByEmail(String email);
    
  //Custom queries using jpql in crud repo

}


/* @Query("SELECT new com.wipro.velocity.ims.model.DealerAddress(d.id,d.email,d.fname,d.lname,"
+ "d.password,d.dob,d.phoneNo,a.street,a.city,a.pincode) "
+ "FROM Dealer d INNER JOIN d.address a")*/