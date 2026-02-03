package yandex_algorithms.first_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class deque_1_opt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String line = br.readLine();

            if (line.charAt(0) == '1') {
                // формат: "1 x"
                int x = Integer.parseInt(line.substring(2));
                queue.addLast(x);
            } else {
                // формат: "2"
                queue.pollFirst();
            }

            if (queue.isEmpty()) {
                out.append("-1\n");
            } else {
                out.append(queue.peekFirst()).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}
