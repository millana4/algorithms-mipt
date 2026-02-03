package yandex_algorithms.first_dictionary;

import java.util.HashMap;
import java.util.Scanner;

public class dict_1 {
    public static void main(String[] args) {
        HashMap<String, String> dict = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String request = scanner.nextLine();
            String[] parts = request.split(" ");

            if (parts[0].equals("1")) {
                dict.put(parts[1], parts[2]);
            } else if (parts[0].equals("2")) {
                String value = dict.get(parts[1]);
                if (value == null) {
                    System.out.println("-1");
                } else {
                    System.out.println(value);
                }
            }
        }
    }
}