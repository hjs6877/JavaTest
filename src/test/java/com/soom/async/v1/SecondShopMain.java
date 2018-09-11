package com.soom.async.v1;

public class SecondShopMain {
    public static void main(String[] args){
        long start = System.nanoTime();
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        System.out.println(bestPriceFinder.findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
}
