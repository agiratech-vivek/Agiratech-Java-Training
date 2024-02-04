package org.collection;

import java.util.Set;

public class Theatre {
    private String name;
    private Set<Movie> movieSet;

    public Theatre() {
    }

    public Theatre(String name, Set<Movie> movieSet) {
        this.name = name;
        this.movieSet = movieSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
    }
}
