package com.classdesign.service;

import com.classdesign.domain.Movie;

import java.util.List;

public interface Movieservice {
    List<Movie> findAll();
    Movie getbyID(Movie m);
}
