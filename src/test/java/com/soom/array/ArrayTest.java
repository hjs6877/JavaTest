package com.soom.array;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-12-21 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class ArrayTest {
    public static void main(String[] args){
        String[] patchNm = {};
        System.out.println(patchNm.length);
        String[] productNm = new String[patchNm.length];

        System.out.println(productNm.length);

        for(int i=0; i < productNm.length; i++){
            productNm[i] = "d";
            System.out.println(productNm[i]);
        }


    }
}
