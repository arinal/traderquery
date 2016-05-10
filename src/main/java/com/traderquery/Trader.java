package com.traderquery;

public class Trader {
    String id;
    String name;
    String city;

    @Override
    public String toString() {
        return "Id: " + id + ", name: " + name + ", City: " + city;
    }
}
