package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task4_last_digit_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // n до 10^14

        // Период Пизано для m = 10
        int pisano = 60;
        long reducedN = (n + 2) % pisano; // F(n+2) mod 10

        // Быстрое вычисление F(reducedN) mod 10
        int a = 0;
        int b = 1;
        for (int i = 0; i < reducedN; i++) {
            int temp = (a + b) % 10;
            a = b;
            b = temp;
        }

        // S(n) = F(n+2) - 1
        int result = (a - 1) % 10;
        if (result < 0) result += 10; // для отрицательных остатков

        System.out.println(result);
    }
}