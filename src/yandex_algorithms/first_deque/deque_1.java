package yandex_algorithms.first_deque;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class deque_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String request = scanner.nextLine();
             String[] parts = request.split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int x = Integer.parseInt(parts[1]);
                deque.addLast(x);
            } else if (type == 2) {
                deque.removeFirst();
            }
            
            if (deque.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(deque.peekFirst());
            }
        }
    }
}
