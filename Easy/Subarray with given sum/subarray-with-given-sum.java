//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends




class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
      static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 

    {

        // Your code here

        int i=0,j=0,sum=0;

        ArrayList<Integer>list=new ArrayList<>();

        while(j<n){

            sum+=arr[j];

            if(sum>s){

                while(sum>s ){

                    sum-=arr[i];

                    i++;

                }

            }

            if(sum==s && j>=i){

                list.add(i+1);

                list.add(j+1);

                return list;

            }

            j++;

        }

        if(list.isEmpty())

        list.add(-1);

        return list;

    }
}