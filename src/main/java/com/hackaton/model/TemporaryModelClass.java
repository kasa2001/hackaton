package com.hackaton.model;

import com.hackaton.interfaces.ResultInterface;

//TODO usunąć klasę
public class TemporaryModelClass implements ResultInterface{

    private String name;
    private int number;

    public TemporaryModelClass(String name, int number) {
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
}
