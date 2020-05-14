package service;

import restaurant.Restaurant;

import java.util.HashMap;

import restaurant.FoodItem;

public interface IRestaurantSelectionStratgey {
    public Restaurant findBy(HashMap<FoodItem, Integer> orderedItems);
}
