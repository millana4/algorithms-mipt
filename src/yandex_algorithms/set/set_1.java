package yandex_algorithms.set;

import java.util.HashSet;
import java.util.Scanner;

public class set_1 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String request = scanner.nextLine();
            String[] parts = request.split(" ");

            if (parts[0].equals("1")) {
                set.add(parts[1]);
            } else if (parts[0].equals("2")) {
                if (set.contains(parts[1])) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
        scanner.close();
    }
}
