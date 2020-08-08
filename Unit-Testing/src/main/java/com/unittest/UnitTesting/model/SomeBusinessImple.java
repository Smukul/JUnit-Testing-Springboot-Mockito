package com.unittest.UnitTesting.model;

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
        return sum;
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
