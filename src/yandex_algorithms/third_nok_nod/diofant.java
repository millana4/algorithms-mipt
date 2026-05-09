package yandex_algorithms.third_nok_nod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class diofant {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(br.readLine());

        long a = Long.parseLong(data.nextToken());
        long b = Long.parseLong(data.nextToken());
        long c = Long.parseLong(data.nextToken());

        // Обработка случаев, когда a = 0 или b = 0
        if (a == 0 && b == 0) {
            // 0*x + 0*y = c
            System.out.println(c == 0 ? "YES" : "NO");
            return;
        }

        if (a == 0) {
            // 0*x + b*y = c => b*y = c
            System.out.println(c % b == 0 ? "YES" : "NO");
            return;
        }

        if (b == 0) {
            // a*x + 0*y = c => a*x = c
            System.out.println(c % a == 0 ? "YES" : "NO");
            return;
        }

        long gcd = gcd(Math.abs(a), Math.abs(b));
        System.out.println(c % gcd == 0 ? "YES" : "NO");
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
