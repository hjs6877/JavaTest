package com.soom.lambda.functional_interface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by kjs on 2016-03-09.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
