package org.collection.controller;

import org.collection.City;
import org.collection.Language;
import org.collection.Movie;
import org.collection.Theatre;
import org.collection.repository.CityRepository;
import org.collection.repository.MovieRepository;
import org.collection.repository.TheatreRepository;

import java.util.*;

public class BookMyShowController {

    private CityRepository cityRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;

    public BookMyShowController() {
        this.cityRepository = new CityRepository();
        this.movieRepository = new MovieRepository();
        this.theatreRepository = new TheatreRepository();
    }

    public City addCity(Scanner scanner){
        System.out.println("Please enter city name");
        String cityName = scanner.next();
        System.out.println("Please enter the number of theatres you want to add in " + cityName);
        int theatreCount = scanner.nextInt();
        List<Theatre> theatreList = new LinkedList<>(); // creating new LinkedList<>()
        while(theatreCount > 0){
            theatreList.add(addTheatre(scanner));
            theatreCount--;
        }
        City city = new City(cityName, theatreList);
        cityRepository.addCity(cityName, city);
        return city;
    }

    public Theatre addTheatre(Scanner scanner){
        System.out.println("Please enter theatre name");
        String theatreName = scanner.next();
        System.out.println("Kindly mention the number of movies you want to add");
        int movieCount = scanner.nextInt();
        Set<Movie> movieSet = new HashSet<>(); // creating new HashSet<>();
        for(int range = 0; range < movieCount; range++){
            movieSet.add(addMovie(scanner));
        }
        Theatre theatre = new Theatre(theatreName, movieSet);
        theatreRepository.addTheatre(theatreName, theatre);
        return theatre;
    }

    public Movie addMovie(Scanner scanner) {
        System.out.println("Please enter movie name");
        String movieName = scanner.next();
        Set<Language> languageList = new HashSet<>(); // creating new HashSet<>()
        languageList.add(Language.ENGLISH);
        languageList.add(Language.HINDI);
        languageList.add(Language.KANNADA);
        languageList.add(Language.MALAYALAM);
        languageList.add(Language.TAMIL);
        Movie movie = new Movie(movieName, languageList);
        movieRepository.addMovie(movieName, movie);
        scanner.nextLine();
        return movie;
    }

    public void removeCity(Scanner scanner){
        System.out.println("Please enter the city name you want to delete");
        String cityName = scanner.next();
        cityRepository.removeCity(cityName);
        System.out.println(cityName + " has been deleted");
    }

    public void removeTheatre(Scanner scanner){
        System.out.println("Please enter theatre name you want to delete");
        String theatreName = scanner.next();
        theatreRepository.removeTheatre(theatreName);
    }

    public void removeMovie(Scanner scanner){
        System.out.println("Please enter the movie name you want to delete");
        String movieName = scanner.next();
        movieRepository.removeMovie(movieName);
    }

    public void getCity(Scanner scanner){
        for(City city : cityRepository.getAllCity()){
            System.out.print(city.getName() + ", ");
        }
        System.out.println("Kindly enter the name of the city");
        String cityName = scanner.next();
        City city = cityRepository.getCity(cityName);
        for (Theatre theatre : city.getTheatres()) {
            System.out.print(theatre.getName() + ", ");
        }
        System.out.println("Select a theatre");
        String theatreName = scanner.next();
        Theatre theatre = theatreRepository.getTheatre(theatreName);
        theatre.getMovieSet().forEach(movie -> System.out.println(movie.getTitle() + ", Available languages: " +movie.getLanguages().toString()));
        System.out.println();
    }
}