package com.soom.exception;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-01-17 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class CClass {
    public void throwCustomException(){
        throw new CustomException("03", "CClass > throwCustomException()에서 예외 던짐.");
    }
}
