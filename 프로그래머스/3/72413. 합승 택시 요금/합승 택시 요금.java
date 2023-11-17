import java.util.*;
class Solution {
 int[][] map;
    int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {


        map = new int[n][n];
        N=n;
        for(int i = 0; i <fares.length;i++){

            int start = fares[i][0];
            int end = fares[i][1];
            int dis = fares[i][2];

            map[start-1][end-1] = dis;
            map[end-1][start-1] = dis;
        }


        int[] together =  dijkstra(s-1);

        int minConst = Integer.MAX_VALUE;
        for(int i = 0 ;i<n;i++){
            int[] alone = dijkstra(i);

            int cost = together[i]+alone[a-1]+alone[b-1];
            minConst = Math.min(minConst,cost);
        }
        return minConst;
    }
    int[] dijkstra(int start){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        int[] distance= new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        boolean[] isVisit = new boolean[N];
        queue.add(new int[] {start,0});

        while (!queue.isEmpty()){
            int[] nowNode = queue.poll();
            if(isVisit[nowNode[0]]) continue;
            isVisit[nowNode[0]] = true;
            for(int i = 0; i<distance.length;i++){
                if(map[nowNode[0]][i] == 0)continue;
                if(distance[i] > distance[nowNode[0]]+map[nowNode[0]][i]){
                    distance[i] = distance[nowNode[0]]+map[nowNode[0]][i];
                    queue.add(new int[] {i,distance[i]});
                }
            }
        }

        return distance;
    }

//     int N;
//     int E;
//     int[][] matrix;
//     public int solution(int n, int s, int a, int b, int[][] fares) {
//         N = n;
//         E = fares.length;
//         matrix = new int[n][n];

//         for (int i = 0; i < E; i++) {
//             int u = fares[i][0] - 1;
//             int v = fares[i][1] - 1;
//             int cost = fares[i][2];
//             matrix[u][v] = cost;
//             matrix[v][u] = cost;
//         }

//         int[] together = dijkstra(s - 1);
//         int minCost = Integer.MAX_VALUE;
//         for(int i = 0; i < N; i++) {
//             int[] alone = dijkstra(i);
//             int cost = together[i] + alone[a - 1] + alone[b - 1];
//             if(cost < minCost) {
//                 minCost = cost;
//             }
//         }

//         return minCost;
//     }

//     public int[] dijkstra(int start) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//         boolean[] visited = new boolean[N];
//         int[] distance = new int[N];
//         Arrays.fill(distance, Integer.MAX_VALUE);
//         distance[start] = 0;
//         pq.add(new int[] {0, start});

//         while (!pq.isEmpty()) {
//             int[] cur = pq.remove();
//             int u = cur[1];
//             if (visited[u]) {
//                 continue;
//             }

//             visited[u] = true;
//             for (int v = 0; v < N; v++) {
//                 if(matrix[u][v] == 0) {
//                     continue;
//                 }
//                 if (distance[u] + matrix[u][v] < distance[v]) {
//                     distance[v] = distance[u] + matrix[u][v];
//                     pq.add(new int[]{distance[v], v});
//                 }
//             }
//         }

//         return distance;
//     }
}