/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdcollectionwebapp.dao;

import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DVDCollectionDaoImplTest {

    private DVDCollectionDao dao;

    public DVDCollectionDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean(DVDCollectionDaoImpl.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMovie method, of class DVDCollectionDaoImpl.
     */
    @Test
    public void testAddGetDeleteMovie() {

        Movie newMovie = new Movie();
        newMovie.setTitle("Boom");
        newMovie.setReleaseDate("2/14/2002");
        newMovie.setMpaaRating("R");
        newMovie.setDirector("Swayze");
        newMovie.setStudio("Hampton's");
        newMovie.setUserNote("Super cool!");

        dao.addMovie(newMovie);

        Movie gottenMovie = dao.getMovieById(newMovie.getId());
        assertEquals(gottenMovie, newMovie);

        dao.removeMovie(newMovie.getId());
        assertNull(dao.getMovieById(newMovie.getId()));
    }

    /**
     * Test of updateMovie method, of class DVDCollectionDaoImpl.
     */
    @Test
    public void testUpdateMovie() {
        Movie newMovie = new Movie();
        newMovie.setTitle("Boom");
        newMovie.setReleaseDate("2/14/2002");
        newMovie.setMpaaRating("R");
        newMovie.setDirector("Swayze");
        newMovie.setStudio("Hampton's");
        newMovie.setUserNote("Super cool!");

        dao.addMovie(newMovie);

        newMovie.setDirector("EEpie");

        dao.updateMovie(newMovie);

        Movie updMovie = dao.getMovieById(newMovie.getId());

        assertEquals(updMovie, newMovie);
    }

    /**
     * Test of getAllMovies method, of class DVDCollectionDaoImpl.
     */
    @Test
    public void testGetAllMovies() {
        Movie newMovie = new Movie();
        newMovie.setTitle("Boom");
        newMovie.setReleaseDate("2/14/2002");
        newMovie.setMpaaRating("R");
        newMovie.setDirector("Swayze");
        newMovie.setStudio("Hampton's");
        newMovie.setUserNote("Super cool!");

        dao.addMovie(newMovie);

        Movie newMovie2 = new Movie();
        newMovie2.setTitle("bip");
        newMovie2.setReleaseDate("5/13/2008");
        newMovie2.setMpaaRating("R");
        newMovie2.setDirector("Sway");
        newMovie2.setStudio("Soul");
        newMovie2.setUserNote("Bummer ride cool!");

        dao.addMovie(newMovie2);

        List<Movie> result = dao.getAllMovies();
        assertEquals(result.size(), 2);

    }

    /**
     * Test of searchMovies method, of class DVDCollectionDaoImpl.
     */
    @Test
    public void testSearchMovies() {
        Movie newMovie = new Movie();
        newMovie.setTitle("Boom");
        newMovie.setReleaseDate("2/14/2002");
        newMovie.setMpaaRating("R");
        newMovie.setDirector("Swayze");
        newMovie.setStudio("Hampton's");
        newMovie.setUserNote("Super cool!");

        dao.addMovie(newMovie);

        Movie newMovie2 = new Movie();
        newMovie2.setTitle("bip");
        newMovie2.setReleaseDate("5/13/2008");
        newMovie2.setMpaaRating("R");
        newMovie2.setDirector("Sway");
        newMovie2.setStudio("Soul");
        newMovie2.setUserNote("Bummer ride cool!");

        dao.addMovie(newMovie2);

        Movie newMovie3 = new Movie();
        newMovie3.setTitle("Goodbye");
        newMovie3.setReleaseDate("7/13/1998");
        newMovie3.setMpaaRating("PG");
        newMovie3.setDirector("Nollie");
        newMovie3.setStudio("Winefest");
        newMovie3.setUserNote("okay i guess");

        dao.addMovie(newMovie3);

        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.TITLE, "bip");
        List<Movie> mList = dao.searchMovies(criteria);
        assertEquals(1, mList.size());
        assertEquals(newMovie2, mList.get(0));

//        criteria.put(SearchTerm.DIRECTOR, "Nollie");
//        mList = dao.searchMovies(criteria);
//        assertEquals(2, mList.size());
//        assertEquals(newMovie3, mList.get(0));

    }

}
