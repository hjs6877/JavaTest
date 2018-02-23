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
public class BClass {
    public void throwAndCatchCustomException(){
        try{
            throw new CustomException("01", "throwAndCatchException()에서 throw 됨.");
        }catch (CustomException ce){
            System.out.println("##throwAndCatchException(): " + ce.getErrorCode() + ", " + ce.getErrorMsg());
        }
    }

    public void throwCustomExceptionToCallMethod(){
        throw new CustomException("01", "throwAndCatchException()에서 main()으로 예외를 알림.");
    }

    public void throwsException() throws Exception{
        double num = 2 / 0;
        System.out.println(num);
    }

    public void throwAndCatchAndThrowCustomException(){
        try{
            throw new CustomException("01", "throwAndCatchAndThrowCustomException()에서 throw 됨.");
        }catch (CustomException ce){
            System.out.println("##throwAndCatchAndThrowCustomException(): " + ce.getErrorCode() + ", " + ce.getErrorMsg());
            throw new CustomException("02", "throwAndCatchAndThrowCustomException()에서 throw 됨.");
        }
    }

    public void throwsCustomExceptionToException() throws Exception {
        CClass cClass = new CClass();
        cClass.throwCustomException();
    }
}
