class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String xString = String.valueOf(x);
        String[] xStringArr = xString.split("");
        int sum = 0;

        for(String splitString : xStringArr){
            sum +=Integer.parseInt(splitString);
        }

        answer = x%sum == 0 ? true : false;

        return answer;
    }
}