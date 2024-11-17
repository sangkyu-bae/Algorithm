

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Integer,Integer> map1 = new HashMap<>();

        for(int i = 0; i < N;i++){
            int a = sc.nextInt();
            map1.put(a, map1.getOrDefault(a,0)+1);
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M;i++){
            int a = sc.nextInt();
            Integer nu = map1.get(a) == null ? 0 : map1.get(a);

            if(i == M-1){
                sb.append(nu);
            }else{
                sb.append(nu + " ");
            }

        }

        System.out.println(sb.toString());

    }



}



