package yandex_algorithms.third_fibo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task6_fibo_representation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Граничный случай
        if (N == 0) {
            System.out.println("0");
            return;
        }

        // Генерируем числа Фибоначчи, начиная с F(2)=1, F(3)=2, F(4)=3, F(5)=5...
        ArrayList<Integer> fibo = new ArrayList<>();
        fibo.add(1); // F(2) = 1
        fibo.add(2); // F(3) = 2

        int nextFibo = 3;
        while (nextFibo <= N) {
            fibo.add(nextFibo);
            nextFibo = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
        }

        // Жадный алгоритм для построения представления
        int remaining = N;
        StringBuilder result = new StringBuilder();

        // Идем от самого большого числа Фибоначчи к меньшему
        for (int i = fibo.size() - 1; i >= 0; i--) {
            int currentFibo = fibo.get(i);

            if (currentFibo <= remaining) {
                result.append('1');
                remaining -= currentFibo;
            } else {
                result.append('0');
            }
        }

        // Убираем ведущие нули и выводим
        String binaryString = result.toString();
        // Находим первую единицу
        int firstOneIndex = binaryString.indexOf('1');
        if (firstOneIndex != -1) {
            System.out.println(binaryString.substring(firstOneIndex));
        } else {
            System.out.println("0");
        }
    }
}