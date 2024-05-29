
import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static int cnt = 0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N];
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            map[depth] = i;
            boolean isattak = isAttack(depth);
            if(isattak){
                dfs(depth + 1);
            }
        }

    }

    static boolean isAttack(int col){
        int colSum = col + map[col];
        int colMin = col - map[col];
        for(int i = 0; i < col;i++){
            if(map[col] == map[i]){
                return false;
            }

            if(colSum == i + map[i]){
                return false;
            }
            if(colMin == i - map[i]){
                return false;
            }
        }

        return true;
    }

}
