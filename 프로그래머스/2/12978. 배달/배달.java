class Solution {
     static final int INF = 9999999;
      int max = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
//         int answer = 0;
//         int[][] map = new int[N][N];

//         for(int i=0;i<N;i++){
//             for(int j=0;j<N;j++){
//                 if(i!=j){
//                     map[i][j]=INF;
//                 }
//             }
//         }

//         for(int i=0;i<road.length;i++){
//             int a=road[i][0];
//             int b=road[i][1];
//             int w=road[i][2];
//             if(map[a-1][b-1]>w){
//                 map[a-1][b-1]=w;
//                 map[b-1][a-1]=w;
//             }
//         }
//         for(int k=0;k<N;k++){
//             for(int i=0;i<N;i++){
//                 for(int j=0;j<N;j++){
//                     if(map[i][j]>map[i][k]+map[k][j]){
//                         map[i][j]=map[i][k]+map[k][j];
//                     }
//                 }
//             }
//         }
//         for(int i=0;i<N;i++){
//             if(map[0][i]<=K){
//                 answer++;
//             }
//         }
//         System.out.println(answer);
//         return answer;
        int answer = 0;
        int max = 9999999;
        int[][] map = new int[N+1][N+1];

        for(int i = 1; i<=N;i++){
            for(int j = 1; j<= N;j++){
                map[i][j] = max;
            }
        }


        for(int i = 0 ;i < road.length;i++){
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];

            if(map[start][end] > time){
                map[start][end] = time;
                map[end][start] = time;
            }

        }
        //거처가는 노드
        for(int k = 1; k <= N ; k++){
            //출발 노드
            for(int i = 1; i <= N; i++){
                //도착 노드
                for(int j = 1; j <= N; j++){
                    if(map[i][j] > map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }


        for(int i = 2; i <= N;i++){
            if(map[1][i] <= K){
                answer++;
            }
        }
        return answer+1;
    }
}