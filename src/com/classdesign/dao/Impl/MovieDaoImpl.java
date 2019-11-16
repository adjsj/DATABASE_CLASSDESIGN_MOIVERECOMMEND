package com.classdesign.dao.Impl;

import com.classdesign.dao.MoiveDao;
import com.classdesign.domain.Movie;
import com.classdesign.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MoiveDao {
    public List<Movie> findAll(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet;
        List<Movie> movies=new ArrayList<>();
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="SELECT * FROM t_movie";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Movie movie=new Movie();
                movie.setMovie_id(resultSet.getInt("mNo"));
                movie.setMovie_name(resultSet.getString("mN"));
                movie.setMovie_another_name(resultSet.getString("mMn"));
                movie.setMovie_type(resultSet.getString("mType"));
                movie.setMovie_language(resultSet.getString("mL"));
                movie.setMovie_date(resultSet.getString("UD"));
                movie.setMovie_location(resultSet.getString("Mcon"));
                movie.setMovie_length(resultSet.getString("TL"));
                movie.setMovie_introduce(resultSet.getString("MBir"));
                movie.setMovie_pic_context(resultSet.getString("Pic"));
                movies.add(movie);
            }
            return movies;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return null;
    }

    @Override
    public Movie getbyID(Movie m) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet;
        try{
            JDBCUtil.loadDriver();
            connection=JDBCUtil.getconnection();
            String sql="SELECT * FROM t_movie WHERE mNo=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,m.getMovie_id());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Movie movie=new Movie();
                movie.setMovie_id(resultSet.getInt("mNo"));
                movie.setMovie_name(resultSet.getString("mN"));
                movie.setMovie_another_name(resultSet.getString("mMn"));
                movie.setMovie_type(resultSet.getString("mType"));
                movie.setMovie_language(resultSet.getString("mL"));
                movie.setMovie_date(resultSet.getString("UD"));
                movie.setMovie_location(resultSet.getString("Mcon"));
                movie.setMovie_length(resultSet.getString("TL"));
                movie.setMovie_introduce(resultSet.getString("MBir"));
                movie.setMovie_pic_context(resultSet.getString("Pic"));
                return movie;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement);
        }
        return null;
    }
}
