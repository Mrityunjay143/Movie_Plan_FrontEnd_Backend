package com.Simplilearn.Fmovie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class User {
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;

	    private String username;

	   
	    private String email;

	  
	    private String password;

	   
	    private int phone;

	  
	    private String street;

	   
	    private String city;
	    
	    private String role;

	    
	    private String zipcode;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getPhone() {
			return phone;
		}

		public void setPhone(int phone) {
			this.phone = phone;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public User( long id,String username, String email, String password, int phone, String street, String city,String role,
				String zipcode) {
			super();
			this.id=id;
			this.username = username;
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.street = street;
			this.role=role;
			this.city = city;
			this.zipcode = zipcode;
		}

      public User() {
    	  
      }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
