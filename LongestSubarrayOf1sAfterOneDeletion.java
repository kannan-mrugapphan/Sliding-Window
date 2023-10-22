// 1493.
// time - O(n) - each element is touched atmost twice once by left and once by right
// space - constant

class Solution {
    public int longestSubarray(int[] nums) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0;
        }

        //brute force - generate all sub arrays, if it has only 1 zero, it is valid, update result - O(n^2)

        int left = 0; //tracks left index of current sliding window
        int zerosSeen = 0; //keeps track of number of 0s seen in current window
        int result = 0; //return value

        for(int right = 0; right < nums.length; right++)
        {
            //account for element at nums[right]
            if(nums[right] == 0)
            {
                zerosSeen++; //update zeros seen
            }

            //as long as array is invalid
            while(left <= right && zerosSeen > 1)
            {
                //there can't be more than one 0 in current window
                if(nums[left] == 0)
                {
                    zerosSeen--;
                }
                left++; //shrink the window till is valid
            }

            //current [left, right] window is valid
            //from this sub array 1 has to be deleted
            result = Math.max(result, right - left);
        }

        return result;
    }
}
