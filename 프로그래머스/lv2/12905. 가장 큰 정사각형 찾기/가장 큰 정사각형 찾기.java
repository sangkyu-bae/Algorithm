class Solution
{
    public int solution(int [][]board)
    {
       int answer = 0;
        int[][] map = new int[board.length][board[0].length];
        
        if(board[0].length<2||board.length<2){
            return 1;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                map[i][j]=board[i][j];
            }
        }


        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[i].length;j++){
                int leftTop = map[i-1][j-1];
                int up = map[i-1][j];
                int left = map[i][j-1];
                if( map[i][j] !=0){
                    int min=Math.min(leftTop,Math.min(up,left))+1;
                    map[i][j]=min;
                    answer = answer < min ? min :answer;
                }
            }
        }
        System.out.println(answer);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer * answer;
    }
}