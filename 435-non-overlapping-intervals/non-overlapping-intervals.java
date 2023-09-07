class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]));
        
        List<int[]> list = new ArrayList();
        int n = intervals.length;
        for(int i = 0;i<intervals.length;i++){
            
            if(list.size() == 0 || (list.get(list.size() - 1)[1] <= intervals[i][0])){
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            else{
                //If it is overlapping then Always try to take the min end element
                list.get(list.size() - 1)[1] = Math.min(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }
        //As we have merged the overlapping ones this means we have reduced the intervals..Thus at the end we just need to find the difference of elements originally in the array and number of elements currently
        return n - list.size();
    }
}