package yandex_algorithms.fourth_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class memory_3_friendship {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(
                new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int g = (int) in.nval;

        int maxId = 0;
        // матрица с запасом: id не превышает n <= 100
        byte[][] adj = new byte[101][101];

        int[] group = new int[101];

        for (int i = 0; i < g; i++) {
            in.nextToken();
            int k = (int) in.nval;

            for (int j = 0; j < k; j++) {
                in.nextToken();
                int v = (int) in.nval;
                group[j] = v;
                if (v > maxId) maxId = v;
            }

            // каждый с каждым внутри группы
            for (int a = 0; a < k; a++) {
                int va = group[a];
                for (int b = a + 1; b < k; b++) {
                    int vb = group[b];
                    adj[va][vb] = 1;
                    adj[vb][va] = 1;
                }
            }
        }

        int n = maxId;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('\n');
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1) sb.append(' ');
                sb.append(adj[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
