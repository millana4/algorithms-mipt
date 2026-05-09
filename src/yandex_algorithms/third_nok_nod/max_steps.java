package yandex_algorithms.third_nok_nod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class max_steps {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 1) {
            System.out.println("1 1");
            return;
        }

        long prev = 1;
        long curr = 1;
        long next = 2;

        // Ищем когда следующее число превысит n
        while (next <= n) {
            prev = curr;
            curr = next;
            next = prev + curr;
        }

        // prev и curr - два наибольших числа Фибоначчи <= n
        // Именно они дают максимальное количество шагов
        System.out.println(prev + " " + curr);
    }
}
