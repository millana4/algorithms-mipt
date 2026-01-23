package yandex_algorithms.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stack_5_balansed {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int balance = 0;
            int len = 0;

            for (int j = i; j < n; j++) {
                if (a[j] % 2 == 1) {
                    balance++;
                } else {
                    balance--;
                }

                if (balance < 0) break;

                len++;

                if (balance == 0) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        System.out.println(maxLen);
    }
}