package com.xiaoyu.algorithm;

import com.xiaoyu.algorithm.PrintAllFile;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.concurrent.atomic.AtomicInteger;


public class TestAlgo {
    @Test
    public void testPrintFile() throws IOException {
        String chemin = "C:\\Users\\XiaoyuLi\\Documents\\Obsidian Vault";
        PrintAllFile.printFileChemin(chemin);
    }

    @Test
    public void testFileWalkTree() {
        AtomicInteger dirCnt = new AtomicInteger();
        AtomicInteger fileCnt = new AtomicInteger();
        try {
            Files.walkFileTree(Paths.get("C:\\Users\\XiaoyuLi\\Documents\\Obsidian Vault"), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("====>" + dir);
                    dirCnt.incrementAndGet();
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file);
                    fileCnt.incrementAndGet();
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("dir cnt:" + dirCnt);
        System.out.println("file cnt:" + fileCnt);
    }
}
