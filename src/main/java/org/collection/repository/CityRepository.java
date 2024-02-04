package org.collection.repository;

import org.collection.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityRepository {
    private static final Map<String, City> cityMap = new HashMap<>();

    public City getCity(String cityName){
        if(!cityMap.containsKey(cityName)) {
            return null;
        }
        return cityMap.get(cityName);
    }

    public void addCity(String cityName, City city){
        cityMap.put(cityName, city);
    }

    public void removeCity(String cityName){
        if(cityMap.containsKey(cityName)) {
            cityMap.remove(cityName);
        } else {
            System.out.println("City does not exist");
        }
    }
    public List<City> getAllCity(){
        List<City> cityList = new ArrayList<>();
        for(String city : cityMap.keySet()){
            cityList.add(cityMap.get(city));
        }
        return cityList;
    }
}
