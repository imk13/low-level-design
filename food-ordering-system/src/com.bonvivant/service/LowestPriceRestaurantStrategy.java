package com.bonvivant.service;

import java.util.HashMap;
import java.util.List;

import com.bonvivant.restaurant.FoodItem;
import com.bonvivant.restaurant.Restaurant;

public class LowestPriceRestaurantStrategy implements IRestaurantSelectionStratgey {
    
    @Override
    public Restaurant findBy(HashMap<FoodItem, Integer> orderedItems, List<Restaurant> allRestaurants){
        return allRestaurants.get(0);
    }
}