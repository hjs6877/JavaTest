package com.soom.codility;

import org.junit.Test;

public class BinaryGap {
    @Test
    public void binaryGapTest(){
        int number = 68;
        String binaryString = Integer.toBinaryString(number);
        String[] str = binaryString.split("");

        int counter = 0;
        int maxCounter = 0;
        int first = 0;
        int end = 0;

        for(String s : str){
            if(Integer.parseInt(s) == 1 && first == 1){
                end = 1;
                first = end;
                if(counter > maxCounter){
                    maxCounter = counter;
                    counter = 0;
                }
            }else if(Integer.parseInt(s) == 1 && first != 1){
                first = 1;
            }else{
                counter++;
            }
        }

        System.out.println(maxCounter);
    }
}
