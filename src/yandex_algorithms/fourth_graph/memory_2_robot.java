package yandex_algorithms.fourth_graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class memory_2_robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size_str = scanner.nextLine();
        String[] size = size_str.split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        char[][] able_matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            able_matrix[i] = line.toCharArray();
        }

        String start_str = scanner.nextLine();
        String[] start = start_str.split(" ");
        int x = Integer.parseInt(start[0]) - 1;   // строка, сдвиг к индексам с 0
        int y = Integer.parseInt(start[1]) - 1;   // столбец

        // направление "вверх": строка уменьшается
        int dx = -1, dy = 0;

        int movings = Integer.parseInt(scanner.nextLine()); // q, не используется напрямую

        Set<Integer> visited = new HashSet<>();
        visited.add(x * m + y);   // стартовая клетка

        String instructions = scanner.nextLine();
        char[] direct = instructions.toCharArray();

        for (char c : direct) {
            switch (c) {
                case 'R': {           // поворот по часовой: (dx,dy) -> (dy,-dx)
                    int t = dx;
                    dx = dy;
                    dy = -t;
                    break;
                }
                case 'L': {           // поворот против часовой: (dx,dy) -> (-dy,dx)
                    int t = dx;
                    dx = -dy;
                    dy = t;
                    break;
                }
                case 'M': {
                    int nx = x + dx;
                    int ny = y + dy;
                    // двигаемся, только если в пределах комнаты и не мебель
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m
                            && able_matrix[nx][ny] != '#') {
                        x = nx;
                        y = ny;
                        visited.add(x * m + y);
                    }
                    break;
                }
            }
        }

        System.out.println(visited.size());
    }
}