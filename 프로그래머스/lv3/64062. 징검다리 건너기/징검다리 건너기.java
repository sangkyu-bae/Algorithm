class Solution {
    public int solution(int[] stones, int k) {
         int answer = 0;
        int min = 1;
        int max = Integer.MAX_VALUE;

        while (max >= min){
            int mid = (min+max)/2;

            if(searchRiver(stones,k,mid)){
                min = mid+1;
                answer = Math.max(answer,mid);
            }else{
                max = mid-1;
            }
        }
        
        return answer;
    }
    
        boolean searchRiver(int[] stones,int k, int friend){
        int check = 0;
        for(int stone : stones){
            if(stone-friend < 0){
                check++;
            }else{
                check = 0;
            }

            if(check == k)
                return false;
        }

        return true;
    }
}