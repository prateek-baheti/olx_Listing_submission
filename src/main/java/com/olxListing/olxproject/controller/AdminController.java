package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.Admin;
import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.Login;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/seeCustomer")
	public ResponseEntity<List<User_Entity>> seeCustomers(){
		return adminService.seeCustomers();
	}
	
	@GetMapping("/login")
	public String loginAdmin(@RequestBody Login login) {
		return adminService.loginAdmin(login);
	}
	
	@GetMapping("/seeAll")
	public ResponseEntity<?> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/seeActiveUsers")
	public List<User_Entity> getActiveUsers(){
		return adminService.getActiveUsers();
	}
	
	@GetMapping("/getListingOfUser/{email}")
	public List<Listing> getListingOfUser(@PathVariable("email") String email){
		return adminService.getListingOfUser(email);
	}
	
	@GetMapping("/logout")
	public String logoutAdmin() {
		return adminService.logoutAdmin();
	}
	
	@GetMapping("/seeExpiredListing")
	public List<Listing> getExpiredListing(){
		return adminService.getExpiredListing();
	}
	
	@PutMapping("/updateCustomer/{email}")
	public String updateCustomer(@PathVariable("email") String email, @RequestBody User_Entity user) {
		return adminService.updateCustomer(email, user);
	}
	
	@PutMapping("/deactivateCustomer/{mail}")
	public String deactivateUser(@PathVariable("mail") String mail) {
		return adminService.deactivateUser(mail);
	}
	
	@PutMapping("/activateCustomer/{mail}")
	public String activateUser(@PathVariable("mail") String mail) {
		return adminService.activateUser(mail);
	}
	
	@PostMapping("/register")
	public String registerAdmin(@RequestBody Admin admin) {
		return adminService.registerAdmin(admin);
	}
	
	@DeleteMapping("/removeListing/{id}")
	public String removeListing(@PathVariable("id") int id) {
		return adminService.removeListing(id);
	}
	

}
