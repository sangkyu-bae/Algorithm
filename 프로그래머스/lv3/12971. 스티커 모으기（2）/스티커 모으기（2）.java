class Solution {
    public int solution(int sticker[]) {
     int answer = 0;
        int length = sticker.length;
        int[] firstDp = new int[length];
        int[] secondDp = new int[length];
        if (length == 1) return sticker[0];
        firstDp[0] = sticker[0];
        firstDp[1] = sticker[0];

        secondDp[0] = 0;
        secondDp[1] = sticker[1];
        for(int i=2;i<sticker.length;i++){
            firstDp[i] = Math.max(firstDp[i-1],firstDp[i-2]+sticker[i]);
            secondDp[i] = Math.max(secondDp[i-1],secondDp[i-2]+sticker[i]);
        }
        answer = Math.max(firstDp[length-2],secondDp[length-1]);
     
        return answer;
    }
}