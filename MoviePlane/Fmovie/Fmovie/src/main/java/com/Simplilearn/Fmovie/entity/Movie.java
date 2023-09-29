package com.Simplilearn.Fmovie.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class Movie {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;


	    private String country;
	    
	   
	    private String genre;

	  
	    private String name;

	   
	    private String description;

	    
	    private BigDecimal price;

	  
	    private String imageUrl;
	    
	    private String Language;
	    
	    private String imdb;

	  
	    @CreationTimestamp
	    private Date dateCreated;

	  
	    @UpdateTimestamp
	    private Date lastUpdated;

		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

		public Date getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(Date lastUpdated) {
			this.lastUpdated = lastUpdated;
		}

	
		public Movie(long id, String country, String genre, String name, String description, BigDecimal price,
				String imageUrl, String language, String imdb, Date dateCreated, Date lastUpdated) {
			super();
			this.id = id;
			this.country = country;
			this.genre = genre;
			this.name = name;
			this.description = description;
			this.price = price;
			this.imageUrl = imageUrl;
			Language = language;
			this.imdb = imdb;
			this.dateCreated = dateCreated;
			this.lastUpdated = lastUpdated;
		}

		public Movie()
		{
			
		}

		public String getLanguage() {
			return Language;
		}

		public void setLanguage(String language) {
			Language = language;
		}

		public String getImdb() {
			return imdb;
		}

		public void setImdb(String imdb) {
			this.imdb = imdb;
		}

		public void setId(long id) {
			this.id = id;
		}


}
