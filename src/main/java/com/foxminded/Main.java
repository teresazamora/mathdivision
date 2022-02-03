package com.foxminded;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Division division = new Division();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your divident: ");
        int dividend = scanner.nextInt();
        System.out.println("Enter your divisor: ");
        int divider = scanner.nextInt();
        DivisionResult result = division.divide(dividend, divider);
        DivisionFormatter formatter = new DivisionFormatter();
        System.out.println(formatter.format(result));

    }
}
