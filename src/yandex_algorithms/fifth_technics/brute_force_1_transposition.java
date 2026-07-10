package yandex_algorithms.fifth_technics;

import java.util.Scanner;

public class brute_force_1_transposition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n_str = scanner.nextLine();
        int n = Integer.parseInt(n_str);

        int n_factorial = 1;

        for (int i = 1; i < n + 1; i++) {
            n_factorial = n_factorial * i;
        }

        System.out.print(n_factorial);
    }
}
