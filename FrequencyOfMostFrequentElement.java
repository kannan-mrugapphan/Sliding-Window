// 1838.
// time - O(nlogn) for sorting + O(n) - each element is touched atmost twice once by left and once by right
// space - constant
class Solution {
    public int maxFrequency(int[] nums, int k) {
        //brute force - find all subarrays - check if sub array is valid
        //a sub array is valid if all elements can be incremented to max in that sub array
        //find largest such subarray

        Arrays.sort(nums);

        int left = 0; //tracks the left of current window
        int runningSum = 0; //tracks the sum of elements from nums[left, right]
        int result = 1; //return value - can never be lower than 1
        
        //right tracks the right of current window
        for(int right = 0; right < nums.length; right++)
        {
            //account for current element
            runningSum += nums[right]; //update running sum

            //check if all elements in [left, right] can be updated to nums[right]
            //length of [left, right] = right - left + 1
            //if all elements can be updated total sum = (right - left + 1) * nums[right] (number of elements in range * nums[right])
            //array is sorted so each element in left till right - 1 is lower than right and can be increased
            //if this total expected sum - current running sum <= k, then all elements can be updated

            //as long as current window is invalid
            while(((right - left + 1) * nums[right]) - runningSum > k && left <= right)
            {
                //remove char at left and account for its removal
                runningSum -= nums[left];
                left++;
            }

            //current window is valid
            result = Math.max(result, (right - left + 1)); 
        }

        return result;
    }
}
