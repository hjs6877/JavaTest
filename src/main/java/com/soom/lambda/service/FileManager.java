package com.soom.lambda.service;

import com.soom.lambda.functional_interface.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kjs on 2016-03-09.
 */
public class FileManager {
    public static String processFileByBufferedReader(BufferedReaderProcessor brp){
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("F:\\3_private_project\\1_project\\4_test\\7_JavaTest\\JavaTest\\src\\main\\resources\\flying.csv"))){
            result = brp.process(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
