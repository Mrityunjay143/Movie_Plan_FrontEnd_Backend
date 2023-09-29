package com.Simplilearn.Fmovie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kuldeep.thakur
 *
 */
@Entity
@Table
public class Countries {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;
	    
	  
	    private String CountryNames;

		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCountryNames() {
			return CountryNames;
		}

		public void setCountryNames(String countryNames) {
			CountryNames = countryNames;
		}
		public Countries()
		{
			
		}

		public Countries(long id, String countryNames) {
			super();
			this.id = id;
			CountryNames = countryNames;
		}

		
		
		

}
