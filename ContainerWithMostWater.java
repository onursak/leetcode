class Solution {
    public int maxArea(int[] height) {
        if(height.length == 2){
            return Math.min(height[0], height[1]);
        }
        int max = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while(leftPointer < rightPointer){
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);
            max = Math.max(max, (rightPointer - leftPointer) * minHeight);
            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }
        return max;
    }
}
