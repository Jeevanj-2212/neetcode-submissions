

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // All numbers are used
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Don't use the same number twice
            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);

            backtrack(nums, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}