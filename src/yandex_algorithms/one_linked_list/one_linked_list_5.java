package yandex_algorithms.one_linked_list;

import java.util.Scanner;

public class one_linked_list_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); 

        String request = scanner.nextLine();
        String[] nums = request.split(" ");
        
        // Преобразуем строки в числа
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }

        StringBuilder result = new StringBuilder();
        int k = 0; // счетчик оставшихся элементов
        
        // Обрабатываем первый элемент
        result.append(array[0]).append(" ");
        k++;
        
        // Проверяем локальные минимумы со 2-го до предпоследнего элемента
        for (int i = 1; i < n - 1; i++) {
            // Проверяем условие локального минимума: a[i-1] > a[i] < a[i+1]
            if (array[i-1] > array[i] && array[i] < array[i+1]) {
                // Это локальный минимум - пропускаем
                continue;
            } else {
                // Не локальный минимум - добавляем
                result.append(array[i]).append(" ");
                k++;
            }
        }
        
        // Обрабатываем последний элемент
        result.append(array[n-1]);
        k++;
        
        scanner.close();
        
        // Выводим количество оставшихся элементов
        System.out.println(k);
        // Выводим оставшиеся элементы
        System.out.println(result.toString().trim());
    }
}