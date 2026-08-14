

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {
            int frequency = map.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        // 3. Get k most frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {

            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}