package yandex_algorithms.set;

import java.io.*;
import java.util.*;

public class set_3_opt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[1_000_001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                int x = Integer.parseInt(st.nextToken());
                count[x]++;
            }
        }

        int answer = 0;
        for (int x = 1; x <= 1_000_000; x++) {
            if (count[x] == n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}