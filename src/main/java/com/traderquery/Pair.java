package com.traderquery;

public class Pair<T1, T2> {
    T1 value1;
    T2 value2;

    public Pair(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
