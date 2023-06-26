//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    private static final int MOD = 1000000007;

    private int binaryExp(int x, int n) {
        if (n == 0) return 1;
        long temp = binaryExp(x, n / 2);
        temp = (temp * temp) % MOD;
        if (n % 2 == 0) return (int) temp;
        else return (int) (((temp * x) % MOD) + MOD) % MOD;
    }

    public int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == n) return 1;
        long ans = 1;
        
        // First calculating the numerator
        for (int i = 1; i <= r; i++) {
            ans = (ans * (i + (n - r))) % MOD;
        }
        
        // Now calculating the final answer by dividing the answer with the terms in the denominator
        for (int i = 1; i <= r; i++) {
            int inv = binaryExp(i, MOD - 2);
            ans = (ans * inv) % MOD;
        }
        
        return (int) ans;
    }
}