package com.xiaoyu.algo;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Consumer;

public class Zigzag {
    public String convert(String s, int numRows) {
        if(s.length() < 3) return s;
        int pointer = 0;
        StringBuilder[] sbArray = new StringBuilder[numRows];
        boolean zigzag = true;
        int indexZig, indexZag;

        for(int i = 0; i < sbArray.length; i++){
            sbArray[i] = new StringBuilder();
        }

        for(int i = 0; i < s.length(); i++){
            if(zigzag) {
                indexZig = i % (numRows - 1);
                sbArray[indexZig].append(s.charAt(i));
                if(indexZig == (numRows - 2)) zigzag = false;
            } else {
                indexZag = numRows - i % (numRows - 1) - 1;
                sbArray[indexZag].append(s.charAt(i));
                if(indexZag == 1) zigzag = true;
            }
        }

        StringBuilder res = new StringBuilder();

        for(StringBuilder sb : sbArray){
            res.append(sb);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Zigzag().convert("PAYPALISHIRING", 3));
    }
}
