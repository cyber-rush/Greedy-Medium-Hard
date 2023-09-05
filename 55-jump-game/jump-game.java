class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastGoodPos = n - 1;
        for(int i = n - 1;i>=0;i--){
            if(i + nums[i] >= lastGoodPos){
                lastGoodPos = i;
            }
        }
        return lastGoodPos == 0;
    }
}