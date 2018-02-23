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
public class CustomException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public CustomException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
