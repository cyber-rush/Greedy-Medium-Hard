class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // Sort by end times

        List<int[]> list = new ArrayList<>();
        int cnt = 0;
        int prevEnd = Integer.MIN_VALUE; // Initialize with the smallest possible value

        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            if (currentStart >= prevEnd) {
                // No overlap with the previous interval, add it to the list
                list.add(currentInterval);
                prevEnd = currentEnd; // Update prevEnd to the end of the current interval
            } else {
                // Overlaps with the previous interval, increment the count
                cnt++;
            }
        }
        
        return cnt;
    }
}