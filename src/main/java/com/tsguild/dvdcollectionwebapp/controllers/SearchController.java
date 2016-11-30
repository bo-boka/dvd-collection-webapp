package com.tsguild.dvdcollectionwebapp.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
        
    public SearchController() {
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String start() {
        
        return "search";
    }
}
