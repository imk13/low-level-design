package com.bonvivant.payments;

import com.bonvivant.order.Order;

public interface IPaymentStrategy {
    void pay(Order order);
}