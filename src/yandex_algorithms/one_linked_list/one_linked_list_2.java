package yandex_algorithms.one_linked_list;
import java.util.Scanner;

public class one_linked_list_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        scanner.nextLine(); // Считываем перевод строки после числа

        int[] array = new int[q];

        String request = scanner.nextLine();
        String[] parts = request.split(" ");
        
        for (int i = 0; i < q; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        scanner.close();

        int minDifference = 2147483647;
        int maxDifference = -2147483647;
        int minIndexI = 0;
        int minIndexJ = 0;
        int maxIndexI = 0;
        int maxIndexJ = 0;

        for (int i = 0; i < q; i++) {
            for (int j = i + 1; j < q; j++) {
                if (array[i] - array[j] < minDifference) {minDifference = array[i] - array[j]; minIndexI = i; minIndexJ = j;};
                if (array[i] - array[j] > maxDifference) {maxDifference = array[i] - array[j]; maxIndexI = i; maxIndexJ = j;};
            }
        }

        minIndexI++;
        minIndexJ++;
        maxIndexI++;
        maxIndexJ++;

        System.out.println(minIndexI + " " + minIndexJ);
        System.out.println(maxIndexI + " " + maxIndexJ);
    }
}