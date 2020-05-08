package com.bonvivant.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.bonvivant.exceptions.BonVivantException;
import com.bonvivant.order.Order;
import com.bonvivant.restaurant.Menu;
import com.bonvivant.restaurant.Restaurant;
import com.bonvivant.service.RestaurantFinder;
import com.bonvivant.service.LowestPriceRestaurantStrategy;

public class RestaurantManager {
    private HashMap<String, Restaurant> restaurantMap;
    private HashMap<String, ArrayList<Order>> restaurantOrdersHistory;

    private static RestaurantManager instance = null;

    private RestaurantManager(){
        this.restaurantMap = new HashMap<>();
        this.restaurantOrdersHistory = new HashMap<>();
    }

    static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaunrant(Restaurant restaurant){
        if(restaurantMap.containsKey(restaurant.getName())){
        //    throw new BonVivantException("Restaurant with this name already present. Copyright violation!");
            return;
        }
        restaurantMap.put(restaurant.getName(), restaurant);
        restaurantOrdersHistory.put(restaurant.getName(), new ArrayList<Order>());
    }

    public Restaurant findRestaurant(String name){
        if(restaurantMap.containsKey(name)){
           return restaurantMap.get(name); 
        }
        return null;
    }

    public Restaurant findBy(HashMap<FoodItem, Integer> orderedItems){
        // TBD
        Restaurant restaurant = new RestaurantFinder()
            .useStrategy(new LowestPriceRestaurantStrategy())
            .findRestaurant(orderedItems, restaurantMap.values());
    }

    public void removeRestaurant(Restaurant restaurant){
        if(restaurantMap.containsKey(restaurant.getName())){
            restaurantMap.remove(restaurant.getName());
            restaurantOrdersHistory.remove(restaurant.getName());
        }

        throw new BonVivantException("Restaurnt not present with this name" + restaurant.getName());
    }

    public List getOrderHistory(Restaurant restaurant){
        if(restaurantMap.containsKey(restaurant.getName())){
            return restaurantOrdersHistory.get(restaurant.getName());
        }
        return null;
    }

    public void placeOrder(Restaurant restaurant, Order order){
        order.setPlacedAt(restaurant.getId());
        if(restaurant.canAcceptOrder()){
            restaurant.addOrders(order);
            restaurantOrdersHistory.get(restaurant.getName()).add(order);
        }
    }
}