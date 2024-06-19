import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException  {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
 
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ansSum = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        int l = 0;
        int r = n -1;
        while (l < r){
            int sum = arr[l] + arr[r];

            if(Math.abs(sum) < ansSum){
                ansSum = Math.abs(sum);
                ans1 = arr[l];
                ans2 = arr[r];
            }

            if(sum > 0){
                r--;
            }else {
                l++;
            }
        }

        if(ans1 > ans2){
            int temp = ans1;
            ans1 = ans2;
            ans2 = temp;
        }

        System.out.println(ans1 + " " + ans2);
    }
}
