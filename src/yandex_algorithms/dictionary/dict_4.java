package yandex_algorithms.dictionary;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class dict_4 {
    static class Element {
        String name;
        int quantity;
        int position;
        int sum;
        int value; // числовое значение элемента

        Element(String name, int value, int position) {
            this.name = name;
            this.value = value;
            this.quantity = 1;
            this.position = position;
            this.sum = name.chars().map(c -> c - '0').sum();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String request = scanner.nextLine();
        String[] parts = request.split(" ");
        
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        // Считаем частоту элементов
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(parts[i]);
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }
        
        // Преобразуем в список элементов с частотой
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(frequency.entrySet());
        
        // Сортируем по частоте (убывание) и значению (возрастание)
        Collections.sort(freqList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                if (a.getValue() != b.getValue()) {
                    return b.getValue() - a.getValue(); // по частоте убывание
                }
                return a.getKey() - b.getKey(); // по значению возрастание
            }
        });
        
        // Нам нужны три различных элемента с максимальной суммарной частотой
        // Просто берем три самых частых (они уже отсортированы)
        // Гарантируется, что есть минимум 3 различных элемента
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = freqList.get(i).getKey();
        }
        
        // Сортируем результат в порядке возрастания
        Arrays.sort(result);
        
        // Выводим результат
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        scanner.close();
    }
}