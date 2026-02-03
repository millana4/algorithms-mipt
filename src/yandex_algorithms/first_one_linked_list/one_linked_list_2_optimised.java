package yandex_algorithms.first_one_linked_list;
import java.util.Scanner;

public class one_linked_list_2_optimised {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        int[] array = new int[q];

        for (int i = 0; i < q; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        int minI = 0, minJ = 1;
        int maxI = 0, maxJ = 1;

        int minValue = array[0];
        int minIndex = 0;

        int maxValue = array[0];
        int maxIndex = 0;

        for (int j = 1; j < q; j++) {
            int cur = array[j];

            // минимальная разность
            if (minValue - cur < minDiff) {
                minDiff = minValue - cur;
                minI = minIndex;
                minJ = j;
            }

            // максимальная разность
            if (maxValue - cur > maxDiff) {
                maxDiff = maxValue - cur;
                maxI = maxIndex;
                maxJ = j;
            }

            // обновляем минимум и максимум слева
            if (cur < minValue) {
                minValue = cur;
                minIndex = j;
            }

            if (cur > maxValue) {
                maxValue = cur;
                maxIndex = j;
            }
        }

        // +1 из-за нумерации с 1
        System.out.println((minI + 1) + " " + (minJ + 1));
        System.out.println((maxI + 1) + " " + (maxJ + 1));
    }
}