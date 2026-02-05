package yandex_algorithms.second_milty;
import java.io.*;
import java.util.*;
public class task2_comlicated {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 6) { // ← ИЗМЕНИЛ УСЛОВИЕ
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
        System.out.print(n + " ");
        for (int i = 1; i < n; i++) {
            System.out.print(i + " ");
        }
    }
}
