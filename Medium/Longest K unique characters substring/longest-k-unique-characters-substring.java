//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = -1, i = 0, j = 0;
        while (j < s.length()) {
            if (map.size() < k) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            else if (map.size() == k) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    j++;
                } else {
                    if (ans < j - i) ans = j - i;
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
            }
        }
        if (map.size() == k && ans < j - i) ans = j - i;
        return ans;
    }
}

