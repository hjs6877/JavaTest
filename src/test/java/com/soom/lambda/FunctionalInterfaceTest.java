package com.soom.lambda;

import com.soom.lambda.service.FileManager;
import org.junit.Test;

import java.io.BufferedReader;

/**
 * Created by kjs on 2016-03-09.
 */
public class FunctionalInterfaceTest {
    @Test
    public void readFileByBufferedReaderTest(){
        String result = FileManager.processFileByBufferedReader((BufferedReader br) -> br.readLine() + "\n\r" + br.readLine());

        System.out.println(result);
    }
}
