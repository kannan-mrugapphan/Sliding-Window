// 3.
// time - O(n) as each char is touched atmost twice once by left and once by right
// space - O(n) for map if no char in s is duplicated
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //edge
        if(s == null || s.length() == 0)
        {
            return 0;
        }

        //brute force - check each substring

        int left = 0; //tracks left index of current window
        int result = 0; //return val - length of longest substring with no repeating chars
        HashMap<Character, Integer> frequency = new HashMap<>(); //keeps track of frequency of each char in window

        for(int right = 0; right < s.length(); right++)
        {
            //account for current char
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);

            //as long as current window is invalid, shrink it
            while(left <= right && frequency.get(s.charAt(right)) > 1)
            {
                //right char is duplicated
                //remove left from window and account for its removal
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                if(frequency.get(s.charAt(left)) == 0)
                {
                    frequency.remove(s.charAt(left));
                }
                left++;
            }

            //if window is valid
            if(left <= right)
            {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
