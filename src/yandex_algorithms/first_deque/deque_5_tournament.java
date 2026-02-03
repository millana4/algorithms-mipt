package yandex_algorithms.first_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class deque_5_tournament {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String powerString = br.readLine();

        ArrayDeque<Integer> playerPower = new ArrayDeque<>();

        for (String num : powerString.split("\\s+")) {
            playerPower.addLast(Integer.parseInt(num));
        }

        while (playerPower.size() > 2) {
            int center = playerPower.removeFirst();
            int right = playerPower.removeFirst();
            int left = playerPower.removeLast();

            int min = Math.min(center, Math.min(right, left));
            int max = Math.max(center, Math.max(right, left));

            // возвращаем двух оставшихся
            if (center != min && center != max) {
                playerPower.addLast(center);
            }
            if (right != min && right != max) {
                playerPower.addLast(right);
            }
            if (left != min && left != max) {
                playerPower.addLast(left);
            }

            // победитель становится текущим
            playerPower.addFirst(max);
        }

        int maxPower = Math.max(playerPower.getFirst(), playerPower.getLast());
        int minPower = Math.min(playerPower.getLast(), playerPower.getLast());

        System.out.println(maxPower + " " + minPower);
    }
}