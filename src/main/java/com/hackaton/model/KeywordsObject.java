package com.hackaton.model;

import com.hackaton.interfaces.ResultInterface;

public class KeywordsObject implements ResultInterface{

    private String name;
    private int number;

    public KeywordsObject(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void increment() {
        this.number++;
    }
}
