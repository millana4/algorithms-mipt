package yandex_algorithms.first_dictionary;

import java.util.HashMap;
import java.util.Scanner;

public class dict_2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> dict = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String request = scanner.nextLine();
        String[] parts = request.split(" ");

        int theBiggest = 0;
        int theBiggestKey = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(parts[i]);
            Integer value = dict.get(num);
            
            if (value == null) {
                value = 1;
            } else {
                value = value + 1;
            }
            
            dict.put(num, value);
            
            if (value > theBiggest) {
                theBiggest = value;
                theBiggestKey = num;
            } else if (value == theBiggest && num < theBiggestKey) {
                theBiggestKey = num;
            }
        }

        System.out.println(theBiggestKey);
    }
}
