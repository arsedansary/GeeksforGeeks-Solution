//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
         char ans = '$';
        if(S.length()==1){
            return S.charAt(0);
        }
        for(int i = 0;i<S.length();i++){
            char element = S.charAt(i);
            int index = S.indexOf(element);
            if(index==S.length()-1){
                return S.charAt(S.length()-1);
            }
            if(index == i && index<S.length()-1){
                int index2 = S.indexOf(element,index+1);
                if (index2 == -1){
                    ans = element;
                    break;
                }
            }
        }
        return ans;
    }
}

