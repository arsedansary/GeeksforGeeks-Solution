//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
        heapify(arr, n, i);
        } 
       
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; // left = 2*i + 1
        int rightChild = 2 * i + 2; // right = 2*i + 2

    // If the left child is larger than the root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

    // If the right child is larger than the largest so far
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

    // If the largest element is not the root
        if (largest != i) 
        {
        // swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

        // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
         buildHeap(arr,n);
         
        for(int i=n-1;i>0;i--)
        {
            //swap
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,i,0);
        }
    }
    
 }
 
 
