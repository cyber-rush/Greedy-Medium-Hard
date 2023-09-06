class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int []> ans = new ArrayList();
        
        int n = intervals.length;
        int i = 0;
        
        //Step 1 --> Add non overlapping intervals
        while(i < n && newInterval[0] > intervals[i][1]){
            ans.add(intervals[i]);
            i++;
        }
        
        //Step 2 --> Merge the overlapping interval into one mergeInterval
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        ans.add(newInterval);
        
        //Step 3 --> Add the remaining to the list
        while(i < n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}