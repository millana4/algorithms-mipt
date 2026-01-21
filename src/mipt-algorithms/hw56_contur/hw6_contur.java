import java.util.*;

public class hw6_contur {

    static final int N = 10;
    static int[][] a = new int[N][N];
    static boolean[][] visited = new boolean[N][N];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Cell {
        int x, y;
        Cell(int x, int y) { this.x = x; this.y = y; }
    }

    static List<Cell> currentCycle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = sc.nextInt();

        boolean[][] globalVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1 && !globalVisited[i][j]) {
                    visited = new boolean[N][N];
                    currentCycle = new ArrayList<>();

                    if (dfs(i, j, -1, -1)) {
                        // проверяем, что цикл действительно окружает чёрные пиксели
                        if (enclosesBlack()) {
                            System.out.println("YES");
                            return;
                        }
                    }

                    // переносим посещённые в глобальные
                    for (int x = 0; x < N; x++)
                        for (int y = 0; y < N; y++)
                            if (visited[x][y])
                                globalVisited[x][y] = true;
                }
            }
        }
        sc.close();

        System.out.println("NO");
    }

    // dfs возвращает true, если найден цикл
    static boolean dfs(int x, int y, int px, int py) {
        visited[x][y] = true;
        currentCycle.add(new Cell(x, y));

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (a[nx][ny] != 1)
                continue;

            if (nx == px && ny == py)
                continue;

            if (visited[nx][ny]) {
                // цикл найден
                currentCycle.add(new Cell(nx, ny));
                return true;
            }

            if (dfs(nx, ny, x, y))
                return true;
        }

        return false;
    }

    // проверяем, окружает ли цикл чёрную область
    static boolean enclosesBlack() {
        boolean[][] blocked = new boolean[N][N];

        // помечаем клетки контура как стены
        for (Cell c : currentCycle) {
            blocked[c.x][c.y] = true;
        }

        // ищем черную точку рядом с контуром
        for (Cell c : currentCycle) {
            for (int k = 0; k < 4; k++) {
                int nx = c.x + dx[k];
                int ny = c.y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (a[nx][ny] == 0) {
                    if (floodCheck(nx, ny, blocked))
                        return true;
                }
            }
        }

        return false;
    }

    // flood-fill, проверяет, выходит ли область за пределы
    static boolean floodCheck(int x, int y, boolean[][] blocked) {
        boolean[][] vis = new boolean[N][N];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(x, y));
        vis[x][y] = true;

        while (!q.isEmpty()) {
            Cell c = q.poll();

            // если чёрная область вышла наружу → НЕ контур
            if (c.x == 0 || c.x == N - 1 || c.y == 0 || c.y == N - 1)
                return false;

            for (int k = 0; k < 4; k++) {
                int nx = c.x + dx[k];
                int ny = c.y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (blocked[nx][ny]) continue; // стена
                if (vis[nx][ny]) continue;

                if (a[nx][ny] == 0) {
                    vis[nx][ny] = true;
                    q.add(new Cell(nx, ny));
                }
            }
        }

        return true; // область полностью внутри
    }
}