package com.example;

import com.example.entity.Restaurant;
import com.example.repos.RestaurantJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantJdbcRepository repository;

    List<Restaurant> getAllRestaurants(){
        return repository.findAll();
    }

    //TODO - Modify query to consider input coordinates
    List<Restaurant> getNearbyRestaurants(){
        String sqlForRestaurants = "SELECT * FROM RESTAURANT";
        return repository.executeGenericQueryForRestaurant(sqlForRestaurants);
    }

}
