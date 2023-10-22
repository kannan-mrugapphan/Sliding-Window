// 713.
// time - O(n) each element is touched atmost twice once by left and once by right
// space - O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0;
        }

        int left = 0; //left pointer of current window
        int runningProduct = 1; //tracks product of current window
        int result = 0;

        for(int right = 0; right < nums.length; right++)
        {
            //account for current element at right
            runningProduct *= nums[right];

            //as long as current window is invalid
            while(left <= right && runningProduct >= k)
            {
                //remove element at left and account for it
                runningProduct /= nums[left];
                left++;
            }

            //current valid window is [left, right];
            //adding right to all prev arrays results in right - left + 1 subarrays
            result += (right - left + 1);
        }

        return result;
    }
}
