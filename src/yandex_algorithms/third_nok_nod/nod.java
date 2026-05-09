package yandex_algorithms.third_nok_nod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nod {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(br.readLine());
        long a = Long.parseLong(data.nextToken());
        long b = Long.parseLong(data.nextToken());

        long first = a;
        long second = b;

        while (second != 0) {
            long remainder = first % second;
            first = second;
            second = remainder;
        }

        System.out.println(first);
    }
}