package yandex_algorithms.first_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class stack_3_summin_opt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        long sum = 0;

        // Обрабатываем первые k элементов
        for (int i = 0; i < k; i++) {
            // Удаляем из дека все элементы, которые >= текущего
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Первый минимум
        sum += arr[deque.peekFirst()];

        // Обрабатываем остальные элементы
        for (int i = k; i < n; i++) {
            // Удаляем элементы, выходящие из окна
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Удаляем из дека все элементы, которые >= текущего
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
            sum += arr[deque.peekFirst()];
        }
        System.out.println(sum);
    }
}
