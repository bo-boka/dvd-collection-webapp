///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tsguild.dvdcollectionwebapp.dao;
//
//import com.tsguild.dvdcollectionwebapp.model.Movie;
//import java.util.List;
//import java.util.Map;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author apprentice
// */
//public class DVDCollectionDaoJdbcImplTest {
//    
//    public DVDCollectionDaoJdbcImplTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of setJdbcTemplate method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testSetJdbcTemplate() {
//        System.out.println("setJdbcTemplate");
//        JdbcTemplate jdbcTemplate = null;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        instance.setJdbcTemplate(jdbcTemplate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMovie method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testAddMovie() {
//        System.out.println("addMovie");
//        Movie newMovie = null;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        Movie expResult = null;
//        Movie result = instance.addMovie(newMovie);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllMovies method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testGetAllMovies() {
//        System.out.println("getAllMovies");
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        List<Movie> expResult = null;
//        List<Movie> result = instance.getAllMovies();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMovieById method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testGetMovieById() {
//        System.out.println("getMovieById");
//        int id = 0;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        Movie expResult = null;
//        Movie result = instance.getMovieById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeMovie method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testRemoveMovie() {
//        System.out.println("removeMovie");
//        int id = 0;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        instance.removeMovie(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchMovies method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testSearchMovies() {
//        System.out.println("searchMovies");
//        Map<SearchTerm, String> criteria = null;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        List<Movie> expResult = null;
//        List<Movie> result = instance.searchMovies(criteria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateMovie method, of class DVDCollectionDaoJdbcImpl.
//     */
//    @Test
//    public void testUpdateMovie() {
//        System.out.println("updateMovie");
//        Movie movie = null;
//        DVDCollectionDaoJdbcImpl instance = new DVDCollectionDaoJdbcImpl();
//        instance.updateMovie(movie);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
