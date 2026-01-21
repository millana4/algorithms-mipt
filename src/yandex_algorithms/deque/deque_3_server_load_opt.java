package yandex_algorithms.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class deque_3_server_load_opt {
    static class Server implements Comparable<Server> {
        long readyTime;
        int index;

        Server(long readyTime, int index) {
            this.readyTime = readyTime;
            this.index = index;
        }

        @Override
        public int compareTo(Server other) {
            if (this.readyTime != other.readyTime) {
                return Long.compare(this.readyTime, other.readyTime);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Server> pq = new PriorityQueue<>();

        // изначально все серверы свободны в момент 0
        for (int i = 0; i < k; i++) {
            pq.add(new Server(0, i));
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long t = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            Server server = pq.poll();

            long start = Math.max(server.readyTime, t);
            long finish = start + d;

            out.append(finish).append(' ');

            server.readyTime = finish;
            pq.add(server);
        }

        System.out.println(out.toString().trim());
    }
}
