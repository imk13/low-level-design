package com.bonvivant.service;

import com.bonvivant.restaurant.Restaurant;
import com.bonvivant.restaurant.FoodItem;

public interface IRestaurantSelectionStratgey {
    public Restaurant findBy(List<FoodItem> orderedItems);
}