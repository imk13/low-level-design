package com.bonvivant.payments;

import com.bonvivant.order.Order;

public class AbstractPayment {
    IPaymentStrategy paymentStrategy;
    Order order;

    public void doPayment(Order order) {
        paymentStrategy.pay(order);
    }
}