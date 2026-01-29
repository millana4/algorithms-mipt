package yandex_algorithms.prioroty_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pq_4_parking {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int counter = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int departure = Integer.parseInt(st.nextToken());

            // Удаляем машины, которые уже уехали к моменту arrival
            while (!queue.isEmpty() && queue.peek() <= arrival) {
                queue.poll();
            }

            // Если есть свободное место - паркуем
            if (queue.size() < k) {
                queue.add(departure);
                counter++;
            }
        }

        System.out.println(counter);
    }
}
