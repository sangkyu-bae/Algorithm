import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
       int answer = 0;
        PriorityQueue <int []> q=new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[2]==o2[2]) return o1[2]-o2[2];
                return o2[2]-o1[2];
            }
        });

//        int diaSum=0;
//        int ironSum=0;
//        int stoneSum=0;
        int gok=picks[0]+picks[1]+picks[2];
//        for(int i=0;i<minerals.length;i++){
//            String mineral=minerals[i];
//            if(i%5==0&&i!=0){
//                int[] sumArr=new int[3];
//                sumArr[0]=diaSum;
//                sumArr[1]=ironSum;
//                sumArr[2]=stoneSum;
//                q.add(sumArr);
//
//                stoneSum=0;
//                ironSum=0;
//                diaSum=0;
//            }
//            if(mineral.equals("diamond")){
//                diaSum+=1;
//                ironSum+=5;
//                stoneSum+=25;
//            }else if(mineral.equals("iron")){
//                diaSum+=1;
//                ironSum+=1;
//                stoneSum+=5;
//            }else if(mineral.equals("stone")){
//                diaSum+=1;
//                ironSum+=1;
//                stoneSum+=1;
//            }
//        }


        for(int i=0;i<minerals.length;i+=5){
            if(gok==0){
                break;
            }
            int diaSum=0;
            int ironSum=0;
            int stoneSum=0;
            gok--;
            for(int j=i;j<i+5;j++){
                if(j==minerals.length){
                    break;
                }
                String type=minerals[j];
                if(type.equals("diamond")){
                    diaSum+=1;
                    ironSum+=5;
                    stoneSum+=25;
                }else if(type.equals("iron")){
                    diaSum+=1;
                    ironSum+=1;
                    stoneSum+=5;
                }else if(type.equals("stone")){
                    diaSum+=1;
                    ironSum+=1;
                    stoneSum+=1;
                }
            }
            int[] sumArr=new int[3];
            sumArr[0]=diaSum;
            sumArr[1]=ironSum;
            sumArr[2]=stoneSum;
            q.add(sumArr);
        }

//        int[] sumArr={diaSum,ironSum,stoneSum};
//        q.add(sumArr);
        while (!q.isEmpty()){
              int[] a=q.poll();
            if(picks[0]!=0){
                answer+=a[0];
                picks[0]--;
            }else if(picks[1]!=0){
                answer+=a[1];
                picks[1]--;
            }else if(picks[2]!=0){
                answer+=a[2];
                picks[2]--;
            }else{
                break;
            }
        }
        return answer;
    }
}