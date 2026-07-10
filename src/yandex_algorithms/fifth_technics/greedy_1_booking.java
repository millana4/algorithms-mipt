package yandex_algorithms.fifth_technics;

import java.util.Arrays;
import java.util.Scanner;

public class greedy_1_booking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine().trim());

        int[][] inters = new int[len][2];
        for (int i = 0; i < len; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            inters[i][0] = Integer.parseInt(parts[0]);   // left
            inters[i][1] = Integer.parseInt(parts[1]);   // right
        }

        // сортируем по правой границе
        Arrays.sort(inters, (a, b) -> Integer.compare(a[1], b[1]));

        int counter = 0;
        int lastEnd = Integer.MIN_VALUE;   // правый конец последнего взятого

        for (int i = 0; i < len; i++) {
            int l = inters[i][0];
            int r = inters[i][1];
            if (l > lastEnd) {
                counter++;
                lastEnd = r;
            }
        }

        System.out.println(counter);
    }
}
