class Solution {
    public int solution(int m, int n, int[][] puddles) {
       int answer = 0;
        int[][] map = new int[n][m];
        int mod = 1000000007;
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        map[0][0] =1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == -1 || (i==0 && j ==0)){
                    continue;
                }
              
                if(i>0 && map[i-1][j] > 0 ) map[i][j] +=map[i-1][j] %mod;
                if(j>0 &&map[i][j-1]>0  )map[i][j] += map[i][j-1]%mod;
//                if (i == 0 && j != 0) {
//                    map[i][j] = map[i][j - 1] < 0 ? -1 : 1;
//                } else if (i != 0 && j == 0) {
//                    map[i][j] = map[i - 1][j] < 0 ? -1 : 1;
//                } else {
//                    int y = map[i - 1][j];
//                    int x = map[i][j - 1];
//                    if (y == -1 && x==-1){
//                        map[i][j] = -1;
//                        continue;
//                    }
//                    if (y == -1) y = 0;
//                    else if (x == -1) x = 0;
//                    map[i][j] = (x + y) %mod;
//                }
            }
        }
        answer = map[n-1][m-1] % mod;
        System.out.println(answer);
        return answer;
    }
}