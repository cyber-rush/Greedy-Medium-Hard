class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandy = 0;
        
        int candyCount[] = new int[n];
        
        for(int i = 0;i < n;i++){
            candyCount[i] = 1;
        }
        
        //Left comparison(front traversal)
        for(int i = 1;i < n;i++){
            if(ratings[i] > ratings[i-1]){
                candyCount[i] = candyCount[i-1] + 1;
            }
        }
        
        //Right comparison(backward traversal)
        for(int i = n-2;i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candyCount[i] = Math.max(candyCount[i], candyCount[i+1] + 1);
            }
        }
        
        //Count total no. of sum candies
        for(int i = 0;i < n;i++){
            totalCandy += candyCount[i];
        }
        return totalCandy;
    }
}