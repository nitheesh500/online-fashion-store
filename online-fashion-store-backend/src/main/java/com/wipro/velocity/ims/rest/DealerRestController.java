package com.wipro.velocity.ims.rest;
import java.util.List;



//import javax.validation.Valid;
//import java.util.Optional.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.ims.exception.ResourceNotFoundException;
import com.wipro.velocity.ims.model.Dealer;
import com.wipro.velocity.ims.repository.UserRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="http://localhost:4200")
public class DealerRestController {
	
	@Autowired
	private UserRepository urepo;

	
	@PostMapping("/dealer")
    public Boolean loginDealer(@Validated @RequestBody Dealer dealer) throws ResourceNotFoundException
    {
        Boolean a=false;;
        String email=dealer.getEmail();
        String password=dealer.getPassword();
        //String verify=dealer.getVerify();
        //System.out.println(email+password);
        Dealer d = urepo.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       
        if(email.equals(d.getEmail()) && password.equals(d.getPassword()) && d.getVerify().equalsIgnoreCase("user"))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
        				a=true;
                }
        return a;
    }
	
	@PostMapping("/adminlogin")
    public Boolean loginAdmin(@Validated @RequestBody Dealer dealer) throws ResourceNotFoundException
    {
        Boolean a=false;;
        String email=dealer.getEmail();
        String password=dealer.getPassword();
        //String verify=dealer.getVerify();
        //System.out.println(email+password);
        Dealer d = urepo.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       
        if(email.equals(d.getEmail()) && password.equals(d.getPassword()) && d.getVerify().equalsIgnoreCase("admin"))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
        				a=true;
                }
        return a;
    }
	
	//Open Postman and make POST request - http://localhost:8085/ims/api/dealers
    //Under body tab --> raw --> Text --> Json and type the json data to be saved
        
    @PostMapping("/dealers")
    public Dealer createDealer(@Validated @RequestBody Dealer dealer) throws ResourceNotFoundException{
         urepo.save(dealer);
         return dealer;
    }
    
    
    @GetMapping("/dealers")
    public List<Dealer> getAllCustomers() {
         return  (List<Dealer>) urepo.findAll();
    }
}
