package com.training.ykb.order.models;

import java.util.List;

public class Order {

    private long         orderId;
    private String       name;
    private List<String> meals;

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }


}
