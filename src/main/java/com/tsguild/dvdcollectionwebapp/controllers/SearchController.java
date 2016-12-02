package com.tsguild.dvdcollectionwebapp.controllers;

import com.tsguild.dvdcollectionwebapp.dao.DVDCollectionDao;
import com.tsguild.dvdcollectionwebapp.model.Movie;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    
    private DVDCollectionDao dao;

    @Inject
    public SearchController(DVDCollectionDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

    @ResponseBody
    @RequestMapping(value="/search/dvds", method=RequestMethod.POST)
    public List<Movie> searchMovies(@RequestBody Map<String, String> searchMap){
        List<Movie> dvds = dao.getAllMovies();
        
        String dvdTitleString = searchMap.get("dvdTitle");
        String dvdReleaseDateString = searchMap.get("dvdReleaseDate");
        String dvdMpaaRatingString = searchMap.get("dvdMpaaRating");
        String dvdDirectorString = searchMap.get("dvdDirector");
        String dvdStudioString = searchMap.get("dvdStudio");
        String dvdUserNoteString = searchMap.get("dvdUserNote");

        
        //CriteriaMap way of search
//        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        if(dvdTitleString != null && !dvdTitleString.isEmpty()){
//            criteriaMap.put(SearchTerm.TITLE, dvdTitleString);
            dvds = dvds.stream()
                    .filter( p -> p.getTitle().contains(dvdTitleString) ) //shortcut lamda expression without caps check
//                    .filter((Movie p) -> {return p.getName().toLowerCase().contains(dvdTitleString.toLowerCase());}) //full lambda expression w/ added caps check
                    .collect(Collectors.toList());
        }
        if(dvdReleaseDateString != null && !dvdReleaseDateString.isEmpty()){
//            criteriaMap.put(SearchTerm.RELEASE_DATE, dvdReleaseDateString);
            dvds = dvds.stream()
                    .filter( p -> p.getReleaseDate().toLowerCase().contains(dvdReleaseDateString.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if(dvdMpaaRatingString != null && !dvdMpaaRatingString.isEmpty()){
//            criteriaMap.put(SearchTerm.MPAA_RATING, dvdMpaaRatingString);
            dvds = dvds.stream()
                    .filter( p -> p.getMpaaRating().toLowerCase().contains(dvdMpaaRatingString.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if(dvdDirectorString != null && !dvdDirectorString.isEmpty()){
//            criteriaMap.put(SearchTerm.DIRECTOR, dvdDirectorString);
            dvds = dvds.stream()
                    .filter( p -> p.getMpaaRating().toLowerCase().contains(dvdDirectorString.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if(dvdStudioString != null && !dvdStudioString.isEmpty()){
//            criteriaMap.put(SearchTerm.STUDIO, dvdStudioString);
            dvds = dvds.stream()
                    .filter( p -> p.getMpaaRating().toLowerCase().contains(dvdStudioString.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if(dvdUserNoteString != null && !dvdUserNoteString.isEmpty()){
//            criteriaMap.put(SearchTerm.USER_NOTE, dvdUserNoteString);
            dvds = dvds.stream()
                    .filter( p -> p.getMpaaRating().toLowerCase().contains(dvdUserNoteString.toLowerCase()))
                    .collect(Collectors.toList());
        }

        
//        dvds = dao.searchMovies(criteriaMap);
        return dvds;
    }
}
