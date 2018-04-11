package com.soom.hackerrank.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SuperReducedString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }

    static String super_reduced_string(String str){
        String[] strArr = str.split("");
        List<String> stringList = new ArrayList<>(Arrays.asList(strArr));

        boolean endFlag = true;

        while (endFlag){
            int size = stringList.size();
            for(int i = 0; i < size; i++){
                if(i == size-1){
                    endFlag = false;
                }else{
                    String cur = stringList.get(i);
                    String next = stringList.get(i+1);
                    if(cur.equals(next)){
                        stringList.remove(i);
                        stringList.remove(i);
                        break;
                    }
                }
            }
            if(size == 0)
                endFlag = false;
        }

        if(stringList.size() == 0)
           return "Empty String";
        else
            return String.join("", stringList);
    }
}
