package yandex_algorithms.first_prioroty_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class DualPriorityItem implements Comparable<DualPriorityItem> {
    int firstPriority;
    int secondPriority;

    public DualPriorityItem(int firstPriority, int secondPriority) {
        this.firstPriority = firstPriority;
        this.secondPriority = secondPriority;
    }

    @Override
    public int compareTo(DualPriorityItem other) {
        if (this.firstPriority != other.firstPriority) {
            return other.firstPriority - this.firstPriority;
        }
        return this.secondPriority - other.secondPriority;
    }
}

public class pq_2_support {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<DualPriorityItem> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(line.nextToken());
            int w = Integer.parseInt(line.nextToken());

            queue.add(new DualPriorityItem(w, d));
        }

        int timeFirst = 0;
        int timeSecond = 0;

        while (!queue.isEmpty()) {
            DualPriorityItem next = queue.poll();
            if (timeFirst <= timeSecond) {
                timeFirst += next.secondPriority;
            } else {
                timeSecond += next.secondPriority;
            }
        }

        System.out.println(Math.max(timeFirst, timeSecond));
    }
}
