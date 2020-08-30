package com.unittest.UnitTesting.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.Arrays.stream;

public class SomeBusinessImple {
    private SomeDataService dataService;

    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    public int sumNumbers(int[] numbers){
        int sum=0;
        for(int n: numbers){
            sum  += n;
        }
        OptionalInt sums = stream(numbers).reduce(Integer::sum);
        return sums.orElse(0);
        //return sum;
    }
    public int sumNumbersUsingSomeService(){
        int sum=0;
        int [] numbers = dataService.retrieveAllData();
        for(int n: numbers){
            sum  += n;
        }
        return sum;
    }
}
