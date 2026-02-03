package yandex_algorithms.first_prioroty_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pq_3_sale {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(line.nextToken());
        int q = Integer.parseInt(line.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer sales = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int sale = Integer.parseInt(sales.nextToken()) * (-1);
            queue.add(sale);
        }

        int maxDiscount = 0;

        for (int i = 0; i < q; i++) {
            int discount = queue.poll() * (-1);
            maxDiscount += discount;
        }

        System.out.println(maxDiscount);
    }
}
