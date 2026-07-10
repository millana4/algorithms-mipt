package yandex_algorithms.fourth_graph;

import java.util.Scanner;

public class memory_4_connections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desp = Integer.parseInt(scanner.nextLine());

        byte[][] adj = new byte[201][201];
        int maxId = 0;

        for (int i = 0; i < desp; i++) {
            String dep = scanner.nextLine();
            String[] emps = dep.split(" ");

            int k = Integer.parseInt(emps[0]);
            int boss = Integer.parseInt(emps[1]);
            if (boss > maxId) maxId = boss;

            for (int j = 2; j <= k; j++) {
                int sub = Integer.parseInt(emps[j]);
                if (sub > maxId) maxId = sub;

                adj[boss][sub] = 1;
                adj[sub][boss] = -1;
            }
        }

        int n = maxId;
        StringBuilder sb = new StringBuilder();
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