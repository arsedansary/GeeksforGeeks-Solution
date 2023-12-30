//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
     public static String[] winner(String arr[], int n) {
        // add your code
        String[] res = new String[2];
        HashMap<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String candidate = arr[i];
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
            int votes = map.get(candidate);
            if (votes > max) {
                max = votes;
                res[0] = candidate;
                res[1] = String.valueOf(max);
            } else if (votes == max && candidate.compareTo(res[0]) < 0) {
                res[0] = candidate;
                res[1] = String.valueOf(max);
            }
        }
    
        return res;
    }
}
 
