package yandex_algorithms.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class stack_2 {
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peekLast() <= x) {
                stack.pollLast();
            }

            out.append(stack.size()).append(' ');
            stack.addLast(x);
        }

        System.out.println(out.toString().trim());
    }
}
