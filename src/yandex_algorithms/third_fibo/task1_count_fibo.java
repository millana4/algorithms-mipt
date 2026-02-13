package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task1_count_fibo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Проверка для n = 0
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Проверка для n = 1
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long[] fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[n]);
    }
}
