package yandex_algorithms.fourth_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class memory_5_floyd_warshall {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(
                new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;

        byte[][] R = new byte[n][n];

        // читаем матрицу смежности прямо в R
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                in.nextToken();
                R[i][j] = (byte) in.nval;
            }
        }

        // транзитивное замыкание (Флойд-Уоршелл)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                // маленькая оптимизация: если из i нельзя в k, пропускаем строку
                if (R[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (R[k][j] == 1) {
                        R[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) sb.append(' ');
                sb.append(R[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
