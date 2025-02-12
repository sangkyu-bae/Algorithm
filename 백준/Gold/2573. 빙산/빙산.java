import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        int year = 0;
        while(true) {
            int count = countIcebergs();
            if(count >= 2) {
                System.out.println(year);
                return;
            }
            if(count == 0) {
                System.out.println(0);
                return;
            }
            
            meltIce();
            year++;
        }
    }
    
    static int countIcebergs() {
        visited = new boolean[N+1][M+1];
        int count = 0;
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    dfs(j, i);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void meltIce() {
        int[][] temp = new int[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] > 0) {
                    int seaCount = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(map[ny][nx] == 0) seaCount++;
                    }
                    temp[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            map[i] = Arrays.copyOf(temp[i], M+1);
        }
    }
    
    static void dfs(int x, int y) {
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 1 || nx > M || ny < 1 || ny > N) continue;
            if(visited[ny][nx] || map[ny][nx] == 0) continue;
            
            dfs(nx, ny);
        }
    }
}