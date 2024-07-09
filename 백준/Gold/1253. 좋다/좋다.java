

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
  
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;

        for(int i = 0 ; i < n ;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            int l = 0;
            int r = n - 1;

            while (l < r){
                if(l == i){
                    l++;
                }else if (r == i){
                    r--;
                }else{
                    try{
                        if(arr[l] + arr[r] == arr[i]){
                            ans ++;
                            break;
                        }else{
                            if(arr[l] + arr[r] > arr[i]){
                                r--;
                            }else{
                                l++;
                            }
                        }
                    }catch (Exception e){
                        System.out.println("i : " + i );
                        System.out.println("l : " + l );
                        System.out.println("r : " + r );
                    }

                }
            }
        }

        System.out.println(ans);

    }
}
