package com.xiaoyu.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class StreamCalculator {
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
