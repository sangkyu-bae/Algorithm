
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Egg> list;
    static int answer;
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        list = new ArrayList<>();
        answer = 0;
        for(int i = 0 ;i < n ;i++){
            list.add(new Egg(sc.nextInt(),sc.nextInt()));
        }

        dfs(0);
        System.out.println(answer);


    }

    public static void dfs(int pick){
        if(pick == n){
            int cnt = 0;
            for(Egg egg:list){
                if(egg.durability <=0){
                    cnt++;
                }
            }

            answer = Math.max(cnt,answer);
            return;
        }

        if(list.get(pick).durability > 0){
            boolean targetExists =false;
            for(int i = 0; i < n;i++){
                if(pick == i)continue;
                Egg egg = list.get(i);
                if(egg.durability < 0)
                    continue;
                targetExists = true;
                list.get(pick).min(egg);
                dfs(pick+1);
                list.get(pick).plus(egg);
            }
            if(!targetExists) dfs(pick+1);
        }else{
            dfs(pick + 1);
        }
    }
}

class Egg{
    int durability;
    int weight;

    public Egg(int d, int w){
        this.durability = d;
        this.weight = w;
    }

    public void min(Egg other){
        this.durability -= other.weight;
        other.durability -= this.weight;
    }

    public void plus(Egg other){
        this.durability += other.weight;
        other.durability += this.weight;
    }
}
