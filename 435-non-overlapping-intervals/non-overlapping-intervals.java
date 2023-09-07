class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort by start times

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
                // Choose the interval with a smaller end time to keep
                if (currentEnd < prevEnd) {
                    prevEnd = currentEnd;
                }
            }
        }

        return cnt;
    }
}