//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public void fun(int[][] grid, int i, int j, int n, int m, boolean[] ans) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            ans[0] = ans[0] & false;
            return;
        }
        if (grid[i][j] == 2) return;
        if (grid[i][j] == 0) {
            ans[0] = ans[0] & true;
            return;
        }
        grid[i][j] = 2;

        fun(grid, i, j + 1, n, m, ans);
        fun(grid, i - 1, j, n, m, ans);
        fun(grid, i, j - 1, n, m, ans);
        fun(grid, i + 1, j, n, m, ans);
    }

    public int closedIslands(int[][] grid, int n, int m) {
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1) {
                    boolean[] ans = {true};
                    fun(grid, i, j, n, m, ans);
                    if (ans[0]) count++;
                }
            }
        }

        return count;
    }
}
