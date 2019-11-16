package com.classdesign.dao;

import com.classdesign.domain.Movie;

import java.util.List;

public interface MoiveDao {
    List<Movie> findAll();
    Movie getbyID(Movie movie);
}
