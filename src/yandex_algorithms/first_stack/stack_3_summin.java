package yandex_algorithms.first_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class stack_3_summin {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer nums = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int summin = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(nums.nextToken());
            if (stack.size() < k) {
                stack.addLast(x);
            } else {
                int segmin = Integer.MAX_VALUE;
                for (int num : stack) {if (num < segmin) {segmin = num;}}
                summin += segmin;
                stack.addLast(x);
                stack.removeFirst();
            }
            if (i == n-1) {
                int segmin = Integer.MAX_VALUE;
                for (int num : stack) {
                    if (num < segmin) {
                        segmin = num;
                    }
                }
                summin += segmin;
            }
        }
        System.out.println(summin);
    }
}
