package yandex_algorithms.second_milty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task1_max_multy {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer nums = new StringTokenizer(br.readLine());

        long max1 = -1;
        long max2 = -1;

        for (int i = 0; i < n; i++) {
            int nextNum = Integer.parseInt(nums.nextToken());

            if (nextNum >= max1) {
                max2 = max1;
                max1 = nextNum;
            } else if (nextNum > max2) {
                max2 = nextNum;
            }
        }
        System.out.println(max1 * max2);
    }
}
