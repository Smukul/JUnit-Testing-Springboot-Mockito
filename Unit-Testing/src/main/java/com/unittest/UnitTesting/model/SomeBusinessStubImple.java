package com.unittest.UnitTesting.model;

public class SomeBusinessStubImple implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{4,5,6};
    }
}
