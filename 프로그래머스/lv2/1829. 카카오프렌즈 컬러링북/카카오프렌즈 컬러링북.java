class Solution {
       int numberOfArea;
    int maxSizeOfOneArea;
    boolean[][]isVisit;
    int tempCnt = 0;
    int[] xMoveArr={1,0,-1,0};
    int[] yMoveArr={0,1,0,-1};
       void dfs(int[][]picture,int x,int y, int nowNum){
        if(isVisit[y][x]){
            return;
        }
        isVisit[y][x]=true;

        tempCnt++;
        for(int i=0;i<xMoveArr.length;i++){
            int xMove=x+xMoveArr[i];
            int yMove=y+yMoveArr[i];
            if(xMove >= 0 && yMove >= 0 && xMove < picture[0].length && yMove < picture.length){
                if(nowNum == picture[yMove][xMove]){
                    dfs(picture,xMove,yMove,nowNum);
                }
            }
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        numberOfArea=0;
        maxSizeOfOneArea=0;

        isVisit=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tempCnt=0;
                if(!isVisit[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    dfs(picture,j,i,picture[i][j]);
                    System.out.println(tempCnt);
                }
                if(maxSizeOfOneArea<tempCnt){
                    maxSizeOfOneArea=tempCnt;
                }
            }
        }


        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
        return answer;
    }
}