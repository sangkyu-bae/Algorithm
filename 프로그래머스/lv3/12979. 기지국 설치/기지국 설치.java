class Solution {
    public int solution(int n, int[] stations, int w) {
      int answer = 0;

        int position = 1;
        int stationPoint = 0;

        while (position <= n){
            if(stationPoint < stations.length && position >= stations[stationPoint]-w){
                position = stations[stationPoint]+w+1;
                stationPoint++;
            }else{
                answer++;
                position += (w*2)+1;
            }
        }

        return answer;
    }
}