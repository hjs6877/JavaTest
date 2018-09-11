package com.soom.async.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FirstShopMain {
    public static void main(String[] args){
        FirstShop shop = new FirstShop("Best FirstShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync2("my favorie product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);

        System.out.println("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing something else...");
    }
}
