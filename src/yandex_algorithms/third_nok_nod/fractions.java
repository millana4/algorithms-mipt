package yandex_algorithms.third_nok_nod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fractions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer data1 = new StringTokenizer(br.readLine());
        long a = Long.parseLong(data1.nextToken());
        long b = Long.parseLong(data1.nextToken());

        StringTokenizer data2 = new StringTokenizer(br.readLine());
        long c = Long.parseLong(data2.nextToken());
        long d = Long.parseLong(data2.nextToken());

        // Суммируем
        long numerator = a * d + c * b;
        long denominator = b * d;

        // Сокращаем
        long gcd = gcd(numerator, denominator);

        System.out.println((numerator / gcd) + " " + (denominator / gcd));
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
