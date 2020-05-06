package com.bonvivant.service;

import com.bonvivant.restaurant.Restaurant;
import com.bonvivant.restaurant.FoodItem;

public class FindRestaurant {
    private IRestaurantSelectionStratgey _restaurantSelectionStratgey;

    FindRestaurant(IRestaurantSelectionStratgey searchBy){
        _restaurantSelectionStratgey = searchBy;
    }

    public Restaurant findRestaurant(List<FoodItem> orderedItems){
        return _restaurantSelectionStratgey.findBy(orderedItems);
    }
}