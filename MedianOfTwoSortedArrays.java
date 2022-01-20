/* 

Time complexity: O(m + n)
Space complexity: O(1)

*/

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        if(nums1.length == 1 && nums2.length == 0){
            return nums1[0];
        }
        if(nums2.length == 1 && nums1.length == 0){
            return nums2[0];
        }
        int mergedLength = nums1.length + nums2.length;
        int medianUpperLimit = mergedLength / 2;
        boolean isEven = mergedLength % 2 == 0;
        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int mergedArrayPointer = 0;
        double median = 0;
        int next = 0;
        while(mergedArrayPointer <= medianUpperLimit){
            if(nums1Pointer >= nums1.length){
                next = nums2[nums2Pointer];
                nums2Pointer++;
            }
            else if(nums2Pointer >= nums2.length){
                next = nums1[nums1Pointer];
                nums1Pointer++;
            }
            else{
                if(nums1[nums1Pointer] < nums2[nums2Pointer]){
                    next = nums1[nums1Pointer];
                    nums1Pointer++;
                }
                else{
                    next = nums2[nums2Pointer];
                    nums2Pointer++;
                }
            }
            if(!isEven && mergedArrayPointer == medianUpperLimit){
                median = next;
            }
            else if(isEven && mergedArrayPointer >= medianUpperLimit - 1){
                median = median + (double) next / 2;
            }
            mergedArrayPointer++;
        }
        
        return median;
    }
}
