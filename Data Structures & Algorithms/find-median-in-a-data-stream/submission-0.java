

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        small.add(num);

        // Make sure every element in small <= every element in large
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        // Balance the sizes
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }

        if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}