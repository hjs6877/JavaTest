package com.soom.lambda;

/**
 * Created by kjs on 2016-07-11.
 */
public class Letter {
    public static String addHeader(String text){
        return "From Kevin: " + text;
    }

    public static String addFooter(String text){

        return text + " Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }


}
