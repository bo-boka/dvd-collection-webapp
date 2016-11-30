/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollectionwebapp.dao;

import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DVDCollectionDaoJdbcImpl implements DVDCollectionDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public static final String SQL_ADD_DVD = "INSERT INTO DVDs (title, releaseDate, mpaaRating, director, studio, userNote)\n" +
"			VALUES (?, ?, ?, ? ,?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=false)
    public Movie addMovie(Movie newMovie) {
        jdbcTemplate.update(SQL_ADD_DVD,
                newMovie.getTitle(),
                newMovie.getReleaseDate(),
                newMovie.getMpaaRating(),
                newMovie.getDirector(),
                newMovie.getStudio(),
                newMovie.getUserNote()
                );
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newMovie.setId(id);
        
        return newMovie;
    }
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM DVDs";

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> allDVDs;
        allDVDs = jdbcTemplate.query(SQL_SELECT_ALL, new DVDMapper());
        return allDVDs;
    }
    
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM DVDs\n" +
"	WHERE DVDs.id = ?";

    @Override
    public Movie getMovieById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID,
                    new DVDMapper(), id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    
    private static final String SQL_REMOVE_DVD_BY_ID = "DELETE FROM DVDs\n" +
"	WHERE id = ?";

    @Override
    public void removeMovie(int id) {
        jdbcTemplate.update(SQL_REMOVE_DVD_BY_ID, id);
    }

    @Override
    public List<Movie> searchMovies(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final String SQL_UPDATE_BY_ID = 
            "UPDATE DVDs SET title = ?, " +
            " releaseDate = ?, mpaaRating = ?, " +
            " director = ?, studio = ?, "+
            " userNote = ? WHERE id = ?";
    
    @Override
    public void updateMovie(Movie movie) {
        
        jdbcTemplate.update(SQL_UPDATE_BY_ID,
                movie.getTitle(),
                movie.getReleaseDate(),
                movie.getMpaaRating(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getUserNote(),
                movie.getId());
    }
    
    private static final class DVDMapper implements RowMapper<Movie>{
//int id, String title, String releaseDate, String mpaaRating, String director, String studio, String userNote
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie mappedDVD = new Movie();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String rDate = rs.getString("releaseDate");
            String rating = rs.getString("mpaaRating");
            String dir = rs.getString("director");
            String st = rs.getString("studio");
            String note = rs.getString("userNote");
            
            mappedDVD.setId(id);
            mappedDVD.setTitle(title);
            mappedDVD.setReleaseDate(rDate);
            mappedDVD.setMpaaRating(rating);
            mappedDVD.setDirector(dir);
            mappedDVD.setStudio(st);
            mappedDVD.setUserNote(note);
            
            return mappedDVD;
        }
        
    }
    
}
