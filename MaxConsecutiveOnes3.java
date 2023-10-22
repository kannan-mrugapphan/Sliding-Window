// 1004.
// time - O(n)
// space - O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0; //no subarrays possible
        }

        int left = 0; //tracks left element of current window
        int result = 0; //returns the length of longest subarray
        int zerosSeen = 0; //tracks count of zeros seen so far in current window

        for(int right = 0; right < nums.length; right++)
        {
            //account for current element in right 
            if(nums[right] == 0)
            {
                zerosSeen++; //current is 0
            }

            //as long as current window is invalid
            while(left <= right && zerosSeen > k)
            {
                //more than one 0s have to be flipped in current window
                //remove left and account for it
                if(nums[left] == 0)
                {
                    zerosSeen--;
                }
                left++;
            }

            //current window is valid
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
