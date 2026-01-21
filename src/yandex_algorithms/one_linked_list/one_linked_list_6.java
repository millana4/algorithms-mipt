package yandex_algorithms.one_linked_list;

import java.util.Scanner;


public class one_linked_list_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] array = new int[n];
        
        // Читаем массив
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Находим максимальный элемент
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        
        // Находим самый правый индекс с максимальным значением
        int lastMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == max) {
                lastMaxIndex = i;
            }
        }
        
        // Выводим результат без элемента на lastMaxIndex
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != lastMaxIndex) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(array[i]);
            }
        }
        
        System.out.println(result.toString());
        scanner.close();
    }
}