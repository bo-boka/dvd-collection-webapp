/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollectionwebapp.dao;

import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDCollectionDaoImpl implements DVDCollectionDao {

    private Map<Integer, Movie> dvdMap = new HashMap<>();
    private static int counter = 0;

    @Override
    public Movie addMovie(Movie newMovie) {
        newMovie.setId(counter);
        counter++;
        dvdMap.put(newMovie.getId(), newMovie);
        return newMovie;
    }

    @Override
    public void removeMovie(int id) {
        dvdMap.remove(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        dvdMap.put(movie.getId(), movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        Collection<Movie> m = dvdMap.values();
        return new ArrayList(m);
    }

    @Override
    public Movie getMovieById(int id) {
        return dvdMap.get(id);
    }

    @Override
    public List<Movie> searchMovies(Map<SearchTerm, String> criteria) {
        String title = criteria.get(SearchTerm.TITLE);
        String releaseDate = criteria.get(SearchTerm.RELEASE_DATE);
        String mpaaRating = criteria.get(SearchTerm.MPAA_RATING);
        String director = criteria.get(SearchTerm.DIRECTOR);
        String studio = criteria.get(SearchTerm.STUDIO);
        String userNote = criteria.get(SearchTerm.USER_NOTE);

        Predicate<Movie> titleMatches;
        Predicate<Movie> releaseDateMatches;
        Predicate<Movie> mpaaRatingMatches;
        Predicate<Movie> directorMatches;
        Predicate<Movie> studioMatches;
        Predicate<Movie> userNoteMatches;

        Predicate<Movie> truePredicate = (m) -> { //m or c??
            return true;
        };

        titleMatches = (title == null || title.isEmpty())
                ? truePredicate
                : (c) -> c.getTitle().equals(title);

        releaseDateMatches = (releaseDate == null || releaseDate.isEmpty())
                ? truePredicate
                : (c) -> c.getReleaseDate().equals(releaseDate);

        mpaaRatingMatches = (mpaaRating == null || mpaaRating.isEmpty())
                ? truePredicate
                : (c) -> c.getMpaaRating().equals(mpaaRating);

        directorMatches = (director == null || director.isEmpty())
                ? truePredicate
                : (c) -> c.getDirector().equals(director);

        studioMatches = (studio == null || studio.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().equals(studio);

        userNoteMatches = (userNote == null || userNote.isEmpty())
                ? truePredicate
                : (c) -> c.getUserNote().equals(userNote);
        
        return dvdMap.values().stream().filter(titleMatches
                .and(releaseDateMatches)
                .and(mpaaRatingMatches)
                .and(directorMatches)
                .and(studioMatches)
                .and(userNoteMatches))
                .collect(Collectors.toList());
    }

}
