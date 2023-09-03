//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Pair{
    int start,end,pos;
    Pair(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Pair> arr = new ArrayList();
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 0;i<N;i++){
            arr.add(new Pair(S[i], F[i],i+1));
        }
        Collections.sort(arr, (a,b) -> (a.end == b.end) ? (a.pos - b.pos) : (a.end - b.end));
        
        int e = arr.get(0).end;
        ans.add(arr.get(0).pos);
        for(int i = 1;i<N;i++){
            if(arr.get(i).start > e){
                ans.add(arr.get(i).pos);
                e = arr.get(i).end;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
