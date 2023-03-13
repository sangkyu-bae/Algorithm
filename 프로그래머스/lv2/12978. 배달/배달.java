class Solution {
     static final int INF = 9999999;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i!=j){
                    map[i][j]=INF;
                }
            }
        }

        for(int i=0;i<road.length;i++){
            int a=road[i][0];
            int b=road[i][1];
            int w=road[i][2];
            if(map[a-1][b-1]>w){
                map[a-1][b-1]=w;
                map[b-1][a-1]=w;
            }
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            if(map[0][i]<=K){
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}