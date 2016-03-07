package com.soom.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by kjs on 2016-03-07.
 */
public class ReadBasicTest {
    private static String path = "F:\\3_private_project\\1_project\\4_test\\7_JavaTest\\JavaTest\\src\\test\\java\\com\\soom\\nio\\";
    @Test
    public void readBasicTest() throws IOException {
       File file = new File(path + "test1.csv");

        FileInputStream fileInputStream = new FileInputStream(file);



        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1048);
        while(channel.read(buffer) > 0)
        {
            buffer.flip();

            for (int i = 0; i < buffer.limit(); i++)
            {
                System.out.print((char) buffer.get());
            }
            buffer.clear(); // do something with the data and clear/compact it.
        }
        channel.close();
        fileInputStream.close();

        channel.close();
   }
}
