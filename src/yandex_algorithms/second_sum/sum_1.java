package yandex_algorithms.second_sum;

import java.util.Scanner;

public class sum_1 {
    static int sumOfTwoDigits(int first, int second) {
        return first + second;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}
