//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
       public int maxIntersections(int[][] lines, int N) {
        // Code here
		
		// [1] SORT THE ARRAY
        
        // First we will sort the array by starting index [increasing order i.e. 1,2,3...]
        // and if starting index same then by ending index [increasing order i.e. 1,2,3...]        
		
        Arrays.sort(lines, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int ans = 0, i = 0;
		
        // DEFINE A PRIORITYQUEUE
        // Define a priority queue and sorting order will be on end index and increasing oder
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        while(i < N) {
			// check each start index of horizontal line
            int currStart = lines[i][0];
            
            // clear all the lines which end point ends before current start point
            while(!q.isEmpty()) {
                int prevEnd = q.peek()[1];
                
                if(prevEnd < currStart){
                    q.poll();
                } else break;
            }
            
            // accquire the lines which has same start point
            while(i < N && lines[i][0] == currStart){
                q.offer(lines[i]);
                i++;
            }
			
			// store the size(if max than previous) of queue as result
            ans = Math.max(ans, q.size());
        }
        return ans;
    }
}
