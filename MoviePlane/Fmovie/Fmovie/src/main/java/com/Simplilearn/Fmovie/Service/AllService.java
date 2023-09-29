package com.Simplilearn.Fmovie.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Simplilearn.Fmovie.dao.CountriesRepo;
import com.Simplilearn.Fmovie.dao.GenreRepo;
import com.Simplilearn.Fmovie.dao.MovieRepo;
import com.Simplilearn.Fmovie.dao.UserRepo;
import com.Simplilearn.Fmovie.entity.Countries;
import com.Simplilearn.Fmovie.entity.Genre;
import com.Simplilearn.Fmovie.entity.Movie;
import com.Simplilearn.Fmovie.entity.User;
@CrossOrigin(origins = "*")
@Service
public class AllService {
  
	
	    @Autowired
	    private UserRepo userRepository;
	    @Autowired 
	    private MovieRepo movieRepository;
	    @Autowired 
	    private GenreRepo genreRepository;
	    @Autowired
	    private CountriesRepo countryRepository;
	    

	
	    public List<User> getAllUsers(){
	        return userRepository.findAll();
	    }

	   
	    public User createUser(@RequestBody User user) {
	    	System.out.print("enter");
	        return userRepository.save(user);
	    }
	    
	    public Optional<User> GetUserByName(String Username) {
	    	return userRepository.findByUsername(Username);
	    }
	    public List<Genre> getAllGenre(){
	        return genreRepository.findAll();
	    }

	   
	    public Genre createGenre(@RequestBody Genre genre) {
	        return genreRepository.save(genre);
	    }

	    public List<Countries> getAllCountry(){
	        return countryRepository.findAll();
	    }

	   
	    public Countries createCountry(@RequestBody Countries country) {
	        return countryRepository.save(country);
	    }


	 
	    public Optional<User> getUserById(@PathVariable Long id) {
	        Optional<User> user = userRepository.findById(id);
	        return user;
	    }
	    public List<Movie> getAllproducts(){
	    	System.out.print("enter");
	        return movieRepository.findAll();
	    }

	    // create product rest api
	    public Movie createProduct(@RequestBody Movie movie) {
	    	
	        return movieRepository.save(movie);
	    }

	    // get product by id rest api
	    public Optional<Movie> getproductById(@PathVariable Long id) {
	        Optional<Movie> movie = movieRepository.findById(id);
	        return movie;
	    }
	    
	  
	    public Page<Movie> getByCountry(String country,int page,int size) {
	       Pageable paging = PageRequest.of(page, size);
	    
	        Page<Movie> movie = movieRepository.findByCountry(country,paging);
	        return movie;
	    }
	 
	    public Page<Movie> getByCountryAsc(String country,int page,int size,String order ) {
		       Pageable paging = PageRequest.of(page, size);
		       Page<Movie> movie=null;
		       if(order.equalsIgnoreCase("Asc"))
		           movie= movieRepository.findByCountryOrderByNameAsc(country, paging);
		      	else if(order.equalsIgnoreCase("Dec"))
		      	{
		      	       movie= movieRepository.findByCountryOrderByNameDesc(country, paging);
		      	}

		        return movie;
		    }

        
	    public Page<Movie> getByGenre(String genre,int page,int size) {
		       Pageable paging = PageRequest.of(page, size);
		        Page<Movie> movie = movieRepository.findByGenre(genre, paging);
		        return movie;
		    }
	    public Page<Movie> getByGenreAsc(String genre,int page,int size,String order ) {
		       Pageable paging = PageRequest.of(page, size);
		       Page<Movie> movie=null;
		       if(order.equalsIgnoreCase("Asc"))
		           movie= movieRepository.findByGenreOrderByNameAsc(genre, paging);
		      	else if(order.equalsIgnoreCase("Dec"))
		      	{
		      	       movie= movieRepository.findByGenreOrderByNameDesc(genre, paging);
		      	}

		        return movie;
		    }
	    
	    public Page<Movie> getByMovieName(String name,int page,int size) {
		       Pageable paging = PageRequest.of(page, size);
		    
		        Page<Movie> movie = movieRepository.findMovieByName(name, paging);
		        return movie;
		    }
		 
		    public Page<Movie> getByMovieAsc(int page,int size,String order ) {
			       Pageable paging = PageRequest.of(page, size);
			       Page<Movie> movie=null;
//			       if(order.equalsIgnoreCase("Asc"))
//			           movie= movieRepository.findAllMovieByAsc(name,paging);
//			      	else if(order.equalsIgnoreCase("Dec"))
//			      	{
//			      	      movie= movieRepository.findAllMovieByDesc(order,paging);
//			      	}
			       movie= movieRepository.findAll(paging);

			        return movie;
			    }


			public void deleteMovieByName(String movieName) {
				movieRepository.deleteMovieByName(movieName);				
			}
		


}




