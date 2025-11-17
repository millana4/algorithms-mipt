import java.util.*;

public class find_way {

    static class Edge {
        int to, time, cost;
        Edge(int to, int time, int cost) {
            this.to = to;
            this.time = time;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int city;
        int time;
        int cost;
        State(int city, int time, int cost) {
            this.city = city;
            this.time = time;
            this.cost = cost;
        }
        @Override
        public int compareTo(State o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine().trim();
        while (data.isEmpty()) {
            data = scanner.nextLine().trim();
        }
        String[] parts = data.split("\\s+");
        int cities = Integer.parseInt(parts[0]);
        int waysQuantity = Integer.parseInt(parts[1]);
        int departure = Integer.parseInt(parts[2]);
        int arrive = Integer.parseInt(parts[3]);
        int maxCost = Integer.parseInt(parts[4]);


        int[][] ways = new int[waysQuantity][4];
        for (int i = 0; i < waysQuantity; i++) {
            String nums = scanner.nextLine().trim();
            while (nums.isEmpty()) {
                nums = scanner.nextLine().trim();
            }
            String[] partsA = nums.split("\\s+");
            for (int j = 0; j < 4; j++) {
                ways[i][j] = Integer.parseInt(partsA[j]);
            }
        }
        scanner.close();


        List<Edge>[] graph = new ArrayList[cities + 1];
        for (int i = 1; i <= cities; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < waysQuantity; i++) {
            int u = ways[i][0];
            int v = ways[i][1];
            int time = ways[i][2];
            int cost = ways[i][3];
            graph[u].add(new Edge(v, time, cost));
        }

        @SuppressWarnings("unchecked")
        TreeMap<Integer, Integer>[] best = new TreeMap[cities + 1];
        for (int i = 1; i <= cities; i++) best[i] = new TreeMap<>();

        PriorityQueue<State> pq = new PriorityQueue<>();
        // стартовое состояние
        best[departure].put(0, 0);
        pq.add(new State(departure, 0, 0));

        int answer = -1;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            Integer recorded = best[cur.city].get(cur.cost);
            if (recorded == null || recorded != cur.time) {
                continue;
            }

            if (cur.city == arrive) {
                answer = cur.time;
                break;
            }

            for (Edge e : graph[cur.city]) {
                int newCost = cur.cost + e.cost;
                if (newCost > maxCost) continue;
                int newTime = cur.time + e.time;

                Map.Entry<Integer, Integer> floor = best[e.to].floorEntry(newCost);
                if (floor != null && floor.getValue() <= newTime) {
                    continue;
                }

                List<Integer> toRemove = new ArrayList<>();
                NavigableMap<Integer, Integer> tail = best[e.to].tailMap(newCost, true);
                for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                    if (entry.getValue() >= newTime) {
                        toRemove.add(entry.getKey());
                    }
                }
                for (Integer k : toRemove) best[e.to].remove(k);

                // добавляем новое состояние
                best[e.to].put(newCost, newTime);
                pq.add(new State(e.to, newTime, newCost));
            }
        }

        System.out.println(answer);
    }
}
