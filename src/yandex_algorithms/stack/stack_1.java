package yandex_algorithms.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class stack_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            String line = br.readLine();

            if (line.charAt(0) == '1') {
                int x = Integer.parseInt(line.substring(2));
                stack.addLast(x);
                System.out.println(x);  // Просто выводим x
            } else {
                stack.removeLast();
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.getLast());  // Выводим новый верхний элемент
                }
            }
        }
    }
}