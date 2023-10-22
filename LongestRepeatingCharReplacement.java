// 424.
// time - O(n) * time to find max value in map (which is constant)
// space - O(n) for map
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>(); //tracks freq of each letter in s
        int left = 0; //tracks left of current window
        int result = 0; //return value - length of largest substring

        for(int right = 0; right < s.length(); right++)
        {
            //account for current char at right
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);

            //as long as current window is not valid
            int maxFrequencyInCurrentSubstring = Collections.max(frequency.values()); //gets the freq of max freq char
            while(left <= right && (right - left + 1) - (maxFrequencyInCurrentSubstring) > k)
            {
                //all remaining chars in current window can't be replaces with max freq char in k steps
                //remove char at left
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
