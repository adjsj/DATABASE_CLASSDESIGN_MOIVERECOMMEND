package com.classdesign.service.Impl;

import com.classdesign.dao.Impl.MovieDaoImpl;
import com.classdesign.dao.MoiveDao;
import com.classdesign.domain.Movie;
import com.classdesign.service.Movieservice;

import java.util.List;

public class MovieserviceImpl implements Movieservice {
    public List<Movie> findAll(){
        MoiveDao moiveDao=new MovieDaoImpl();
        return moiveDao.findAll();
    }

    @Override
    public Movie getbyID(Movie m) {
        MoiveDao moiveDao=new MovieDaoImpl();
        return moiveDao.getbyID(m);
    }
}
