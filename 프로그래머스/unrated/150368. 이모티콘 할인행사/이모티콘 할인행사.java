import java.util.*;
class Solution {
        static List<Imoticon> imoticonList = new ArrayList<>();
    static int maxJoin=Integer.MIN_VALUE, maxPrice = Integer.MIN_VALUE;
    static int[]discount={10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int []answer=new int[2];
        dfs(0,users,emoticons);
               answer[0]=maxJoin;
        answer[1]=maxPrice;
        return answer;
    }
        static class Imoticon{
        double price;
        double percent;
        Imoticon(double price, double percent){
            this.price = price;
            this.percent = percent;
        }
    }
      public static void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            int join=0;
            int total=0;

            for(int i=0;i<users.length;i++){
                int userPercent=users[i][0];
                int userPrice=users[i][1];
                int sum=0;

                for(int j=0;j<imoticonList.size();j++){
                    double imoticonPercent=imoticonList.get(j).percent;
                    double imoticonPrice=imoticonList.get(j).price;

                    if(imoticonPercent>=userPercent){
                        sum+=imoticonPrice;
                    }
                }
                if(sum>=userPrice){
                    join++;
                }else{
                    total+=sum;
                }
            }
            
            if(join>maxJoin){
                maxJoin=join;
                maxPrice=total;
            }else if(join==maxJoin&&total>maxPrice){
                maxPrice=total;
            }
            return;
        }

        for(int i=0;i<discount.length;i++){
            imoticonList.add(new Imoticon((emoticons[depth]/100)*(100-discount[i]), (discount[i])));
            dfs( depth+1, users, emoticons);
            imoticonList.remove(imoticonList.size()-1);
        }
    }
}