package com.xiaoyu.algorithm;

import java.io.File;
import java.util.Objects;
import java.util.Stack;

public class PrintAllFile {
    public static void printFileChemin(String chemin){
        File f = new File(chemin);

        if (!f.exists()){
            System.out.println(f.toPath() + " not exist");
            return;
        }

        if(f.isFile()) {
            System.out.println(f.getAbsoluteFile());
            return;
        }

        Stack<File> fileStack = new Stack<>();
        fileStack.push(f);
        while(!fileStack.isEmpty()){
            f = fileStack.pop();

            for (File file : Objects.requireNonNull(f.listFiles())) {
                System.out.println(file.getAbsoluteFile());
                if(file.isDirectory()) fileStack.push(file);
            }
        }
    }
}
