import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static boolean[] visit = new boolean[101];

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // 보드 초기화
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        // 사다리 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x] = y; // x번 칸에 도착하면 y번 칸으로 이동
        }

        // 뱀 입력
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            board[u] = v; // u번 칸에 도착하면 v번 칸으로 이동
        }

        // BFS를 위한 큐
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 0)); // 1번 칸에서 시작, 이동 횟수 0
        visit[1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int position = current.position;

            // 100번 칸에 도착하면 출력 후 종료
            if (position == 100) {
                System.out.println(current.moves);
                return;
            }

            // 주사위 이동
            for (int dice = 1; dice <= 6; dice++) {
                int nextPosition = position + dice;
                if (nextPosition > 100) continue;

                // 이동 후 사다리/뱀 적용
                nextPosition = board[nextPosition];

                // 방문하지 않은 칸만 큐에 추가
                if (!visit[nextPosition]) {
                    visit[nextPosition] = true;
                    queue.add(new Point(nextPosition, current.moves + 1));
                }
            }
        }
    }

    static class Point {
        int position, moves;

        public Point(int position, int moves) {
            this.position = position;
            this.moves = moves;
        }
    }
}