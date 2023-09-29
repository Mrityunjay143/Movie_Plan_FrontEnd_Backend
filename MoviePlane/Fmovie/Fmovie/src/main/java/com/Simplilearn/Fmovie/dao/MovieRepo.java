package com.Simplilearn.Fmovie.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import com.Simplilearn.Fmovie.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	// Page<Movie> findAllByOrderByNameAsc(Pageable pageable);
	//
	// Page<Movie> findAllByOrderByDateCreatedDesc(Pageable pageable);

	// by Cuisines

	// @Query("SELECT e FROM Movie e WHERE e.genre like :name%")
	Page<Movie> findByGenre(@RequestParam("genre") String genre, Pageable pageable);

	Page<Movie> findByGenreOrderByNameAsc(@RequestParam("genre") String genre, Pageable pageable);

	Page<Movie> findByGenreOrderByNameDesc(@RequestParam("genre") String genre, Pageable pageable);

	// Page<Movie> findByGenreOrderByOrderByDateCreatedDesc(@RequestParam("genre")
	// String genre,@RequestParam("name") String name, Pageable pageable);

	Page<Movie> findByCountry(@RequestParam("country") String country, Pageable pageable);

	Page<Movie> findByCountryOrderByNameAsc(@RequestParam("country") String country, Pageable pageable);

	Page<Movie> findByCountryOrderByNameDesc(@RequestParam("country") String country, Pageable pageable);

	// Page<Movie> findAllMovieByName(Pageable pageable);
	// Page<Movie> findAllMovieByDesc(String order,Pageable pageable);
	Page<Movie> findMovieByName(@RequestParam("name") String name, Pageable pageable);

	// Page<Movie> findMovieByNameOrderByNameAsc( Pageable pageable);
	// Page<Movie> findMovieByNameOrderByNameDesc( Pageable pageable);
	Page<Movie> findByNameContainingOrderByDateCreatedDesc(@RequestParam("name") String name, Pageable pageable);

	@Transactional
    @Modifying
    @Query(value = "DELETE FROM fmovies.movie WHERE name = ?1", nativeQuery = true)
	void deleteMovieByName(String movieName);

}
