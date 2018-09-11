package com.soom.async.v1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class BestPriceFinder {
    private final List<SecondShop> shops = Arrays.asList(new SecondShop("BestPrice"),
            new SecondShop("LetsSaveBig"),
            new SecondShop("MyFavoriteShop"),
            new SecondShop("BuyItAll")/*,
            new SecondShop("ShopEasy")*/);


    public List<String> findPrices(String product){
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(product))
                )
                .collect(toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }
}
