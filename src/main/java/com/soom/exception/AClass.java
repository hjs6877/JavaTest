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
public class AClass {
    public static void main(String[] args){
        BClass bClass = new BClass();
//        bClass.throwAndCatchCustomException();
//
//        try{
//            bClass.throwCustomExceptionToCallMethod();
//        }catch (CustomException ce){
//            System.out.println("##main(): " + ce.getErrorCode() + ", " + ce.getErrorMsg());
//        }

//        try{
//            bClass.throwAndCatchAndThrowCustomException();
//        }catch (CustomException e){
//            System.out.println("##main(): " + e.getErrorCode() + ", " + e.getErrorMsg());
//        }

        try{
            bClass.throwsCustomExceptionToException();
        }catch (CustomException ce){
            System.out.println("### main(): " + ce.getErrorCode() + ", " + ce.getErrorMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
