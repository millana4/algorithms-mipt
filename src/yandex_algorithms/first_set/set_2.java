package yandex_algorithms.first_set;

import java.util.HashSet;
import java.util.Scanner;

public class set_2 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();

            for (int j = 1; j <= k; j++) {
                int element = scanner.nextInt();
                set.add(element);
            }
        }
        scanner.close();

        System.out.println(set.size());
    }
}
