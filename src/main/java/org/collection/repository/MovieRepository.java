package org.collection.repository;

import org.collection.Movie;

import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextServices;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
    private static final Map<String, Movie> movieDatabase = new HashMap<>();


    public Movie getMovie(String movieName){
        return movieDatabase.get(movieName);
    }

    public void addMovie(String movieName, Movie movie){
        movieDatabase.put(movieName, movie);
    }

    public void removeMovie(String movieName) {
        movieDatabase.remove(movieName);
    }

}
