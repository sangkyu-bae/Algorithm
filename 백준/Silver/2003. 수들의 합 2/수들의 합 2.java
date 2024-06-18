import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int r=0;
        int sum = arr[0];
        int ans = 0;
        for(int l = 0;l < n;l++){
            if(l != 0){
                sum -= arr[l-1];
            }

            while (r + 1 < n && sum < m ){
                r++;
                sum += arr[r];
            }

            if(sum == m){
                ans++;
            }
        }

        System.out.println(ans);

    }
}
