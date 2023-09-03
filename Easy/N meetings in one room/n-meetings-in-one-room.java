//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair{
    int st,en,pos;
    Pair(int st,int en,int pos){
        this.st = st;
        this.en = en;
        this.pos = pos;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arr.add(new Pair(start[i], end[i], i));
        }
        Collections.sort(arr, (a,b) -> (a.en == b.en) ? (a.pos - b.pos) : (a.en - b.en));
        
        int e = arr.get(0).en;
        int cnt = 1;
        for(int i = 1;i<n;i++){
            if(arr.get(i).st > e){
                cnt++;
                e = arr.get(i).en;
            }
        }
        return cnt;
    }
}
