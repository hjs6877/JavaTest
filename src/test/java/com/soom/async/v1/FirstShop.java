package com.soom.async.v1;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class FirstShop {
    private final String name;
    private final Random random;

    public FirstShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try{
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch(Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();

        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
