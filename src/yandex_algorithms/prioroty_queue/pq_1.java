package yandex_algorithms.prioroty_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class pq_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> prQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.charAt(0) == '1') {
                int x = Integer.parseInt(line.substring(2)) * (-1);
                prQueue.add(x);
                if (prQueue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(prQueue.peek() * (-1));
                }
                } else {
                prQueue.poll();
                if (prQueue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(-prQueue.peek());
                }
            }
        }
    }
}
