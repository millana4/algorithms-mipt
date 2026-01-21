package yandex_algorithms.one_linked_list;

import java.util.Scanner;

public class one_linked_list_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Считываем перевод строки после числа

        String request = scanner.nextLine();
        String[] parts = request.split(" ");
        
        int min = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(parts[i]);
            if (num < min) {
                min = num;
            }
            result.append(min);
            if (i < n - 1) {
                result.append(" ");
            }
        }
        
        scanner.close();
        System.out.println(result.toString());
    }
}