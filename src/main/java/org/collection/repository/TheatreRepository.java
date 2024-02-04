package org.collection.repository;

import org.collection.City;
import org.collection.Theatre;

import java.util.HashMap;
import java.util.Map;

public class TheatreRepository {
    private static final Map<String, Theatre> theatreDatabase = new HashMap<>();

    public Theatre getTheatre(String theatreName){
        return theatreDatabase.get(theatreName);
    }

    public void addTheatre(String theatreName, Theatre theatre){
        theatreDatabase.put(theatreName, theatre);
    }

    public void removeTheatre(String theatreName) {
        theatreDatabase.remove(theatreName);
    }
}
