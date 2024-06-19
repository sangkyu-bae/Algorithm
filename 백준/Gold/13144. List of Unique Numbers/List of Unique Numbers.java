import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  throws IOException{
    
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] cnt = new int[100001];
         StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        int r = 0;
        for(int l = 1; l <= n ;l++){
            while (r + 1 <= n && cnt[arr[r + 1]] == 0){
                r++;
                cnt[arr[r]]++;
            }

            ans+= r - l +1;

            cnt[arr[l]]--;


        }

        System.out.println(ans);

    }
}
