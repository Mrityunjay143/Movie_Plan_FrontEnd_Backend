package com.Simplilearn.Fmovie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;
	    
	   
	    public Genre(long id, String genreName) {
			super();
			this.id = id;
			GenreName = genreName;
		}

		private String GenreName;

		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	
		public Genre()
		{
			
		}

		public String getGenreName() {
			return GenreName;
		}

		public Genre( String genreName) {
			super();
			GenreName = genreName;
		}

		public void setGenreName(String genreName) {
			GenreName = genreName;
		}
		 
}
