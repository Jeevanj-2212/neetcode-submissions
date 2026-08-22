class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();

        int max = 0;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < s.length()) {

            if (!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                count++;
                max = Math.max(max, count);
                j++;
            } 
            else {
                hs.remove(s.charAt(i));
                i++;
                count--;
            }
        }

        return max;
    }
}