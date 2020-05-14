package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import restaurant.FoodItem;
import restaurant.Restaurant;
import system.RestaurantManager;

public class LowestPriceRestaurantStrategy implements IRestaurantSelectionStratgey {

    @Override
    public Restaurant findBy(HashMap<FoodItem, Integer> orderedItems) {
        ArrayList<Restaurant> restaurants= RestaurantManager.getInstance().getAllRestaurant();
        return null;
    }
}
