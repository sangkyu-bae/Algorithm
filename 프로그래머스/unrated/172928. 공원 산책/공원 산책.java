class Solution {
        int x = 0;
    int y = 0;
    int xLength = 0;
    int yLength = 0;

    boolean[][] isMap;
    public int[] solution(String[] park, String[] routes) {
           int[] answer = new int[2];
        xLength = park[0].length();
        yLength = park.length;
        isMap = new boolean[yLength][xLength];

        for (int i = 0; i < park.length; i++) {
            String map = park[i];
            for (int j = 0; j < map.length(); j++) {
                if (map.charAt(j) == 'S') {
                    x = j;
                    y = i;
                    isMap[i][j]=true;
                }else if(map.charAt(j) == 'X'){
                    isMap[i][j]=false;
                }else{
                    isMap[i][j]=true;
                }
            }
        }

        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            String direction = splitRoute[0];
            int distance =Integer.parseInt(splitRoute[1]);
            if (direction.equals("E")) {
                checkMap("x",distance);
            } else if (direction.equals("S")) {
                checkMap("y",distance);
            } else if (direction.equals("W")) {
                checkMap("x",-distance);
            } else if (direction.equals("N")) {
                checkMap("y",-distance);
            }
        }
        System.out.println(x);
        System.out.println(y);
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
    
        void checkMap(String point, int distance){
        int checkDis = distance > 0 ? distance :-distance;
        boolean isCheck = true;
        if(point.equals("x")){
            int xPoint = x+distance;
            int xLength = isMap[0].length;
            if(xPoint >= 0 && xLength > xPoint){
                for(int i = 1;i <= checkDis;i++){
                    int plus = distance > 0 ? i : -i;
                    if(!isMap[y][x+plus]){
                        isCheck = false;
                        break;
                    }
                }
                if(isCheck){
                    x+=distance;
                }
            }
        } else if (point.equals("y")) {
            int yPoint = y+distance;
            int yLength = isMap.length;
            if(yPoint >= 0 && yLength > yPoint ){
                for(int i = 1;i <= checkDis;i++){
                    int plus = distance > 0 ? i : -i;
                    if(!isMap[y+plus][x]){
                        isCheck = false;
                        break;
                    }
                }
                if(isCheck){
                    y+=distance;
                }
            }
        }
    }
}