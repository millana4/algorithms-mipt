package yandex_algorithms.fifth_technics;

import java.util.Scanner;

public class brute_force_2_combination {
    public static int factorial(int num) {
        int factorial = 1;
        for (int i = 1; i < num + 1; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nk_str = scanner.nextLine();
        String[] parts = nk_str.split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        int n_factorial = factorial(n);
        int k_factorial = factorial(k);
        int n_k_factorial = factorial(n - k);

        int comb = n_factorial / (n_k_factorial * k_factorial);

        System.out.print(comb);
    }
}
