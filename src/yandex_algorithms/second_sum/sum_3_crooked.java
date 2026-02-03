package yandex_algorithms.second_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sum_3_crooked {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder c = new StringBuilder();

        for (int i = 0; i < n; i++) {
            c.append(a.charAt(i));
            c.append(b.charAt(i));
        }

        System.out.println(c);
    }
}
