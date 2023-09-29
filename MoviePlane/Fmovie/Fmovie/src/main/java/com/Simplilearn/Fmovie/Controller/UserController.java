package com.Simplilearn.Fmovie.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Simplilearn.Fmovie.Service.AllService;
import com.Simplilearn.Fmovie.dao.UserRepo;
import com.Simplilearn.Fmovie.entity.Countries;
import com.Simplilearn.Fmovie.entity.Genre;
import com.Simplilearn.Fmovie.entity.Movie;
import com.Simplilearn.Fmovie.entity.User;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private AllService allservice;
	
	 // get all users
	@GetMapping("/")
	public void Home()
	{
	  System.out.print("Hii");
	}
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return allservice.getAllUsers();
    }

    // create user rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return allservice.createUser(user);
    }
 // get user by id rest
    @GetMapping("/users/{name}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String name) {
    	  Optional<User> user = allservice.GetUserByName(name);
           return ResponseEntity.ok(user);
    }
    @GetMapping("/country")
    public List<Countries> getAllCountry(){
        return allservice.getAllCountry();
    }

    // create user rest api
    @PostMapping("/genre")
    public Genre createGenre(@RequestBody Genre genre) {
        return allservice.createGenre(genre);
    }
    @GetMapping("/genre")
    public List<Genre> getAllGenre(){
        return allservice.getAllGenre();
    }

    // create user rest api
    @PostMapping("/country")
    public Countries createUser(@RequestBody Countries country) {
        return allservice.createCountry(country);
    }
    @GetMapping("/movie")
    public List<Movie> getAllproducts(){
    	System.out.print("enter");
        return allservice.getAllproducts();
    }
    
    @GetMapping("/movie/movies")
    public Page<Movie> getAllmovies(@RequestParam(defaultValue = "0") int page,
  	      @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "dec") String order){
    	System.out.print("enter");
        return allservice.getByMovieAsc(page, size, order);
    }
    // create product rest api
    @PostMapping("/movie")
    public Movie createProduct(@RequestBody Movie movie) {
        return allservice.createProduct(movie);
    }

    // get product by id rest api
    @GetMapping("/movie/id/{id}")
    public ResponseEntity<Optional<Movie>> getproductById(@PathVariable Long id) {
        Optional<Movie> movie = allservice.getproductById(id);
        return ResponseEntity.ok(movie);
    }
   /* @GetMapping("/movie/name/{name}")
    public ResponseEntity<Page<Movie>> getByName(@PathVariable String name ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "3") int size) {
    
        Page<Movie> movie = allservice.getByMovieName(name, page, size);
        return ResponseEntity.ok(movie);
    }*/
    @GetMapping("/movie/name/{name}")
    public ResponseEntity<Page<Movie>> getByNameAsc(@PathVariable String name ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "10") int size) {
    	
        Page<Movie> movie = allservice.getByMovieName(name, page, size);
        return ResponseEntity.ok(movie);
    }
 
    
   /* @GetMapping("/movie/country/{country}")
    public ResponseEntity<Page<Movie>> getByCountry(@PathVariable String country ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "3") int size) {
    	//Pageable paging=null;
    //	@RequestParam(defaultValue = "desc") String sortValue
    	/*if(sortValue.equalsIgnoreCase("Asc"))
    	   paging = PageRequest.of(page, size,Sort.by(country).ascending());
    	else
    		 paging = PageRequest.of(page, size,Sort.by(country).ascending());*/
    	 
      /*  Page<Movie> movie = allservice.getByCountry(country,page,size);
        return ResponseEntity.ok(movie);
    }*/
    @GetMapping("/movie/country/{country}")
    public ResponseEntity<Page<Movie>> getByCountryAsc(@PathVariable String country ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "dec") String order) {
    	
        Page<Movie> movie = allservice.getByCountryAsc(country, page, size, order);
        return ResponseEntity.ok(movie);
    }
  /*  @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<Page<Movie>> getByGenre(@PathVariable String genre ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "3") int size) {
    	
        Page<Movie> movie = allservice.getByGenre(genre,page,size);
        return ResponseEntity.ok(movie);
    }*/
    @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<Page<Movie>> getByGenreAsc(@PathVariable String genre ,@RequestParam(defaultValue = "0") int page,
    	      @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "dec") String order) {
    	
        Page<Movie> movie = allservice.getByGenreAsc(genre,page,size,order);
        return ResponseEntity.ok(movie);
    }
    
    @DeleteMapping("/deletMovie/name")
    public String deleteMovie(@RequestParam("movieName") String movieName){
    	allservice.deleteMovieByName(movieName);
    	return "Movie Deleted";
    }
    
}
