package com.classdesign.web.action;

import com.classdesign.domain.Movie;
import com.classdesign.service.Impl.MovieserviceImpl;
import com.classdesign.service.Movieservice;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/homepage")
public class Movieservlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String methodname=request.getParameter("method");
        if(methodname.equals("findAll")){
            findAll(request,response);
        }else if(methodname.equals("search")){
            search(request,response);

        }
    }

    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

    }
    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        int id= Integer.valueOf(request.getParameter("id"));
        Movie movie=new Movie();
        movie.setMovie_id(id);
        Movieservice movieservice=new MovieserviceImpl();
        Movie movieexit=movieservice.getbyID(movie);
        request.setAttribute("movie",movieexit);
        request.getRequestDispatcher("/view/movieshow.jsp").forward(request,response);

    }
        public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        int count=0;
        Movieservice movieservice=new MovieserviceImpl();
        List<Movie> movies=movieservice.findAll();
        for (Movie movie:movies) {
            count++;
            request.setAttribute("movie"+count,movie);
        }
        request.getRequestDispatcher("/view/homepage.jsp").forward(request,response);

    }
}