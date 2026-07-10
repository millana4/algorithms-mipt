package yandex_algorithms.fifth_technics;

import java.util.Scanner;

public class brute_force_5_servers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        // маска совместимости каждого клиента
        int[] clientMask = new int[p];
        for (int j = 0; j < p; j++) {
            int t = scanner.nextInt();
            int mask = 0;
            for (int x = 0; x < t; x++) {
                int server = scanner.nextInt() - 1;  // индексы с 1 -> с 0
                mask |= (1 << server);
            }
            clientMask[j] = mask;
        }

        long bestCost = Long.MAX_VALUE;
        int bestSet = -1;

        int total = 1 << n;  // 2^n подмножеств
        for (int s = 0; s < total; s++) {
            // ровно K серверов
            if (Integer.bitCount(s) != k) continue;

            // проверяем, что все клиенты покрыты
            boolean ok = true;
            for (int j = 0; j < p; j++) {
                if ((s & clientMask[j]) == 0) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;

            // суммарная задержка этого набора
            long cost = 0;
            for (int i = 0; i < n; i++) {
                if ((s & (1 << i)) != 0) {
                    cost += w[i];
                }
            }

            if (cost < bestCost) {
                bestCost = cost;
                bestSet = s;
            }
        }

        if (bestSet == -1) {
            System.out.print("No solutions");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(bestCost).append('\n');
            boolean first = true;
            for (int i = 0; i < n; i++) {
                if ((bestSet & (1 << i)) != 0) {
                    if (!first) sb.append(' ');
                    sb.append(i + 1);   // обратно к нумерации с 1
                    first = false;
                }
            }
            System.out.print(sb);
        }
    }
}
