package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task2_last_digit {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }

        System.out.println(curr);
    }
}
