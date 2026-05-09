package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task5_partial_sum_last_digit {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(br.readLine());
        long m = Long.parseLong(data.nextToken());
        long n = Long.parseLong(data.nextToken());

        // Период Пизано для m = 10
        int pisano = 60;

        // Считаем S(n) = F(n+2) - 1
        long reducedN = (n + 2) % pisano;
        int sumToN = (fastFiboMod10(reducedN) - 1) % 10;

        // Считаем S(m-1) = F((m-1)+2) - 1 = F(m+1) - 1
        long reducedM = (m + 1) % pisano;  // для m=0 обработаем отдельно
        int sumToMminus1;

        if (m == 0) {
            sumToMminus1 = 0;  // S(-1) = 0
        } else {
            sumToMminus1 = (fastFiboMod10(reducedM) - 1) % 10;
        }

        // S(m,n) = S(n) - S(m-1)
        int result = (sumToN - sumToMminus1) % 10;
        if (result < 0) result += 10;

        System.out.println(result);
    }

    // Быстрое вычисление F(k) mod 10
    private static int fastFiboMod10(long k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= k; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}