package com.soom.nio;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Spliterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-03-09.
 */
public class PathTest {
    @Test
    public void pathApiTest(){
//        Path path = Paths.get("F:\\3_private_project\\1_project\\4_test\\7_JavaTest\\JavaTest\\src\\main\\resources\\flying.csv");
        Path path1 = Paths.get("F:", "3_private_project", "1_project", "4_test/7_JavaTest/JavaTest/src/main/resources/flying.csv");
        Path path2 = Paths.get("/3_private_project", "1_project", "4_test/7_JavaTest/JavaTest/src/main/resources/flying.csv");
        Path path3 = Paths.get("/3_private_project", "1_project", "4_test/_JavaTest/JavaTest/src/main/resources/../flying.csv");
        Path path4 = Paths.get(System.getProperty("user.home"));

        System.out.println("path1.getFileName():" + path1.getFileName());
        System.out.println("path2.getFileName():" + path2.getFileName());
        System.out.println(path1.getFileSystem());
        System.out.println(path1.getName(0));
        System.out.println(path1.getNameCount());    // F: 제외.
        System.out.println("path1.getParent(): " + path1.getParent());
        System.out.println("path2.getParent(): " + path2.getParent());
        System.out.println("path3.getParent(): " + path3.getParent());
        System.out.println("path4.getParent(): " + path4.getParent());

        System.out.println("path1 root 디렉토리: " + path1.getRoot());
        System.out.println("path2 root 디렉토리: " + path2.getRoot());
        System.out.println(path1.isAbsolute());

        Iterator<Path> iter = path1.iterator();
        System.out.println("============= path.iterator() ==================");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("===============================");

        System.out.println("Sub Path: " + path1.subpath(0, 3));
        System.out.println("to URI : " + path1.toUri());
        System.out.println("path1.normalize(): " + path1.normalize());
        System.out.println("path3.normalize(): " + path3.normalize());

        System.out.println("path1.toString(): " + path1.toString());
        System.out.println("path2.toAbsolute(): " + path2.toAbsolutePath());

        // TODO 사용법 찾아보기기
        Spliterator<Path> sIter = path1.spliterator();



        File file = path1.toFile();

        assertEquals(true, file.exists());
    }
}
