// 340.
// time - O(n)
// space - O(k)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>(); //keeps track of frequency of each letter in current window
        int left = 0;
        int result = 0; //return value

        for(int right = 0; right < s.length(); right++)
        {
            //account for char at right
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);

            //as long as current window is invalid
            while(left <= right && frequency.keySet().size() > k)
            {
                //current window has more than k unique chars
                //remove char at left and account for it
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                if(frequency.get(s.charAt(left)) == 0)
                {
                    frequency.remove(s.charAt(left));
                }
                left++;
            }

            //current window is valid
            if(left <= right)
            {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
