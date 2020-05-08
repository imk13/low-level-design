package com.bonvivant.service;

import com.bonvivant.restaurant.Restaurant;

import java.util.HashMap;

import com.bonvivant.restaurant.FoodItem;

public interface IRestaurantSelectionStratgey {
    public Restaurant findBy(HashMap<FoodItem, Integer> orderedItems);
}