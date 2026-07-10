package yandex_algorithms.fourth_graph;
import java.util.Scanner;

public class memory_1_matrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String md = scanner.nextLine();
        String[] parts = md.split(" ");
        int sts = Integer.parseInt(parts[0]);

        byte[][] matrix1 = new byte[sts][sts];
        byte[][] matrix2 = new byte[sts][sts];

        int rts = Integer.parseInt(parts[1]);

        for (int i = 0; i < rts; i++) {
            String route_str = scanner.nextLine();
            String[] route = route_str.split(" ");
            int size = route.length;

            // route[0] -- это k (кол-во остановок), сами остановки с route[1]
            for (int j = 1; j < size; j++) {
                int curr = Integer.parseInt(route[j]) - 1;

                // первый граф: связь с предыдущей остановкой на маршруте
                if (j > 1) {
                    int prev = Integer.parseInt(route[j - 1]) - 1;
                    matrix1[curr][prev] = 1;
                    matrix1[prev][curr] = 1;
                }

                // второй граф: связь со всеми предыдущими остановками маршрута
                for (int t = 1; t < j; t++) {
                    int other = Integer.parseInt(route[t]) - 1;
                    matrix2[curr][other] = 1;
                    matrix2[other][curr] = 1;
                }
            }
        }

        // вывод
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sts; i++) {
            for (int j = 0; j < sts; j++) {
                if (j > 0) sb.append(' ');
                sb.append(matrix1[i][j]);
            }
            sb.append('\n');
        }
        for (int i = 0; i < sts; i++) {
            for (int j = 0; j < sts; j++) {
                if (j > 0) sb.append(' ');
                sb.append(matrix2[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}