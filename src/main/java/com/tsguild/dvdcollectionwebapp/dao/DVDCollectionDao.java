/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollectionwebapp.dao;

import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDCollectionDao {

    Movie addMovie(Movie newMovie);

    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    void removeMovie(int id);

    List<Movie> searchMovies(Map<SearchTerm, String> criteria);

    void updateMovie(Movie movie);
    
}
