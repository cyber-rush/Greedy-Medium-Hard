//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class Pair{
    int weight;
    int price;
    double perUnit;
    Pair(int price,int weight,double perUnit){
        this.price=price;
        this.weight=weight;
        this.perUnit=perUnit;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        ArrayList<Pair> list = new ArrayList();
        for(int i = 0;i<n;i++){
            double perUnitValue = 1.0 *(arr[i].value) / arr[i].weight;
            list.add(new Pair(arr[i].value, arr[i].weight, perUnitValue));
        }
        Collections.sort(list, (a, b) -> Double.compare(b.perUnit, a.perUnit));
        
        double cost = 0.0;
        for(int i = 0;i<n;i++){
            if(list.get(i).weight > W){
                cost += W*list.get(i).perUnit;
                break;
            }
            else{
                cost += list.get(i).price;
                W = W - list.get(i).weight;
            }
        }
        return cost;
        
    }
}