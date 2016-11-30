package com.tsguild.dvdcollectionwebapp.controllers;

import com.tsguild.dvdcollectionwebapp.dao.DVDCollectionDao;
import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {
    
    private DVDCollectionDao dao;
        
    @Inject
    public HomeController(DVDCollectionDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String displayHome() {
        return "home";
    }
    
    @ResponseBody
    @RequestMapping(value="/dvds", method=RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return dao.getAllMovies();
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/dvd", method=RequestMethod.POST)
    public Movie createEntry(@RequestBody Movie incomingMovie){ //add @Valid
        dao.addMovie(incomingMovie);
        return incomingMovie;
    }
    
    @ResponseBody
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.GET)
    public Movie getDVDById(@PathVariable("id")int dvdId){
        return dao.getMovieById(dvdId);
    }
    
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.PUT)
    public void updateDVD(@PathVariable int id, @RequestBody Movie updatedMovie){
        updatedMovie.setId(id);
        dao.updateMovie(updatedMovie);
    
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.DELETE)
    public void deleteDVD(@PathVariable int id){
        dao.removeMovie(id);
    }
    
}
