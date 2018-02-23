package com.soom.hackerrank;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-12-06 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class BinaryNumbersTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String binaryString = Integer.toBinaryString(num);

        int sum = 0;
        int maxNum = 0;

        for(int i=0; i < binaryString.length(); i++){
            String s = String.valueOf(binaryString.charAt(i));
            if(s.equals("1")){
                sum++;
                if(sum > maxNum){
                    maxNum = sum;
                }
            }else{
                sum = 0;
            }
        }

        System.out.println(maxNum);
    }
}
