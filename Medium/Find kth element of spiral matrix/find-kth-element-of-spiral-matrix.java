//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k) {
	  ArrayList<Integer> list=new ArrayList<>();
	  int r=0;
	  int c=0;
	  
	  while(r<n&&c<m){
	      for(int i=c;i<m;i++){
	          list.add(A[r][i]);
	      }
	      r++;
	      
	      for(int i=r;i<n;i++){
	          list.add(A[i][m-1]);
	      }
	      m--;
	      
	      if(r<n){
	          for(int i=m-1;i>=c;i--){
	              list.add(A[n-1][i]);
	          }
	          n--;
	      }
	      
	      if(c<m){
	          for(int i=n-1;i>=r;i--){
	              list.add(A[i][c]);
	          }
	          c++;
	      }
	  }
	  
	  int ans=0;
	  for(int i=0;i<k;i++){
	      ans=list.get(i);
	  }
	  
	  return ans;
	
    }
}