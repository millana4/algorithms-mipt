package yandex_algorithms.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class stack_5_balanced_opt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        int balance = 0;

        // Карта: баланс → первая позиция, где он встретился
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1); // начальный баланс 0 на позиции -1

        for (int i = 0; i < n; i++) {
            // Обновляем баланс: +1 для нечётного, -1 для чётного
            balance += (arr[i] % 2 == 1) ? 1 : -1;

            // Если баланс ушёл в минус - это некорректно, сбрасываем
            if (balance < 0) {
                balance = 0;
                firstSeen.clear();
                firstSeen.put(0, i);
                continue;
            }

            // Если такой баланс уже встречался
            if (firstSeen.containsKey(balance)) {
                int start = firstSeen.get(balance);
                maxLen = Math.max(maxLen, i - start);
            } else {
                // Сохраняем первую позицию для этого баланса
                firstSeen.put(balance, i);
            }
        }

        System.out.println(maxLen);
    }
}