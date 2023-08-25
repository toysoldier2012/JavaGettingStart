package com.xiaoyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BinaryOperator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Maj+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Maj+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}

class QuestionJava {
    static String var = "we";

    public static void main(String[] data) {
        Integer[] tab = new Integer[3];
        tab[0] = 2;
        tab[1] = 5;
        tab[2] = 8;
        System.out.println(Arrays.toString(tab));
    }
}


class StreamCalculator {

    public static void main(String[] args) {
        // Map to store operators and corresponding functions
        Map<String, BinaryOperator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        // Sample calculations
        System.out.println("Result of 5 + 3 = " + calculate(operators, "5", "+", "3"));
        System.out.println("Result of 10 - 6 = " + calculate(operators, "10", "-", "6"));
        System.out.println("Result of 2 * 4 = " + calculate(operators, "2", "*", "4"));
        System.out.println("Result of 15 / 3 = " + calculate(operators, "15", "/", "3"));
    }

    public static int calculate(Map<String, BinaryOperator<Integer>> operators, String a, String operator, String b) {
        // Convert input strings to integers
        int operand1 = Integer.parseInt(a);
        int operand2 = Integer.parseInt(b);

        // Retrieve the corresponding operator function from the map
        BinaryOperator<Integer> operation = operators.get(operator);

        // Perform the calculation and return the result
        return operation.apply(operand1, operand2);
    }
}
