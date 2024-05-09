
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int gr = sc.nextInt();
        int gc = sc.nextInt();

        int MAX_VALUE = 1000000000;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] map = new int[n + 1][n + 1];
        int[][][] cost = new int[2][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= n; j++) {
                char ch = s.charAt(j - 1);

                if (ch == '#') map[i][j] = 1;
                else map[i][j] = 0;

                cost[0][i][j] = MAX_VALUE;
                cost[1][i][j] = MAX_VALUE;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1.cost - o2.cost;
                }
        );
        pq.add(new Point(1, 1, 0, 0));
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.r == gr && now.c == gc) {
                System.out.println(now.cost);
                return;
            }

            if (cost[now.change][now.r][now.c] < now.cost) continue;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (!isValid(nr, nc, n)) continue;
                Point next = new Point(nr, nc, 0, now.cost + 1);
                if (cost[0][nr][nc] > next.cost) {
                    cost[0][nr][nc] = next.cost;
                    pq.add(next);
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                int newCost = now.cost + t * (now.change == 0 ? 1 : 0) + 1;
                while (true) {
                    if (!isValid(nr, nc, n)) break;
                    if (map[nr][nc] == 1) {
                        if (cost[1][nr][nc] > newCost) {
                            cost[1][nr][nc] = newCost;
                            pq.add(new Point(nr, nc, 1, newCost));
                        }
                        break;
                    }

                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }
    }

    static class Point {
        int cost;
        int c;
        int r;
        int change;

        public Point(int r, int c, int change, int cost) {
            this.cost = cost;
            this.c = c;
            this.r = r;
            this.change = change;
        }
    }

    static boolean isValid(int r, int c, int n) {
        return r >= 1 && r <= n && c >= 1 && c <= n;
    }
}