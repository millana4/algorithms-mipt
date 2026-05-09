package yandex_algorithms.third_nok_nod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nok {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(br.readLine());
        long a = Long.parseLong(data.nextToken());
        long b = Long.parseLong(data.nextToken());

        long gcd = gcd(a, b);
        long lcm = (a / gcd) * b;

        System.out.println(lcm);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
