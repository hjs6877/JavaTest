package com.soom.hackerrank.exception;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-02-22 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class Calculator {
    /**
     * - n 또는 p중에 0보다 작은 수가 있다면 예외를 던진다.
     *
     * @param n
     * @param p
     * @return
     */
    public int power(int n, int p) throws Exception {
        int result = 1;
        if(n < 0 || p < 0)
            throw new Exception("n and p should be non-negative");
        else
            for(int i=0; i < p; i++){
                result = result * n;
            }

        return result;
    }
}
