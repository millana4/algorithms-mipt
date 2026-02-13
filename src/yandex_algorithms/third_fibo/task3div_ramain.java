package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task3div_ramain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(br.readLine());
        long n = Long.parseLong(data.nextToken());
        int m = Integer.parseInt(data.nextToken());

        // n >= 1 по условию
        if (n == 1) {
            System.out.println(1 % m);  // 1 % m всегда 1 при m >= 2
            return;
        }

        // Находим период Пизано для ускорения
        int period = findPisanoPeriod(m);
        long reducedN = n % period;  // уменьшаем n по модулю периода

        // Если reducedN = 0, это значит n кратно периоду,
        // что соответствует F(period) % m = 0
        if (reducedN == 0) {
            System.out.println(0);
            return;
        }
        if (reducedN == 1) {
            System.out.println(1 % m);
            return;
        }

        int prev = 0;
        int curr = 1;

        // Вычисляем для reducedN
        for (int i = 2; i <= reducedN; i++) {
            int next = (prev + curr) % m;  // ОШИБКА БЫЛА ЗДЕСЬ: вы делали лишние проверки
            prev = curr;
            curr = next;
        }

        System.out.println(curr);
    }

    // Метод для нахождения периода Пизано
    private static int findPisanoPeriod(int m) {
        int prev = 0;
        int curr = 1;

        // Период не превышает m * m
        for (int i = 0; i <= m * m; i++) {
            int next = (prev + curr) % m;
            prev = curr;
            curr = next;

            // Период начинается с 0, 1, ...
            if (prev == 0 && curr == 1) {
                return i + 1;  // длина периода
            }
        }
        return m * m;  // fallback
    }
}
