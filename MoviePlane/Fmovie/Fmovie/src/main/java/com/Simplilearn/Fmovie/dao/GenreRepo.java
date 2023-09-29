package com.Simplilearn.Fmovie.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.Simplilearn.Fmovie.entity.Genre;
import com.Simplilearn.Fmovie.entity.Movie;
@Repository
public interface GenreRepo extends JpaRepository<Genre,Long>{
	 Page<Movie> findByGenreName(@RequestParam("GenreName") String GenreName, Pageable pageable);
}
