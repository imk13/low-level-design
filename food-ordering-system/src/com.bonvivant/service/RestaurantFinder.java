package com.bonvivant.service;

import com.bonvivant.restaurant.Restaurant;

import java.util.HashMap;

import com.bonvivant.exceptions.BonVivantException;
import com.bonvivant.restaurant.FoodItem;

public class RestaurantFinder {
    private IRestaurantSelectionStratgey _restaurantSelectionStratgey;
    
    public RestaurantFinder(){
    }

    public useStrategy(IRestaurantSelectionStratgey stratgey){
        _restaurantSelectionStratgey = stratgey;
        return this;
    }

    public Restaurant findRestaurant(HashMap<FoodItem, Integer> orderedItems, List<Restaurant> allRestaurants){
        if(_restaurantSelectionStratgey == null){
            throw new BonVivantException("IRestaurantSelectionStratgey strategy is not set.");
        }
        return _restaurantSelectionStratgey.findBy(orderedItems, allRestaurants);
    }
}