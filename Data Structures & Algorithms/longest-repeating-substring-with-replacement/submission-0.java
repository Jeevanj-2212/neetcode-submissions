class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int max = 0;

        while (j < s.length()) {

            freq[s.charAt(j) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            int windowLength = j - i + 1;

            if (windowLength - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            max = Math.max(max, j - i + 1);

            j++;
        }

        return max;
    }
}