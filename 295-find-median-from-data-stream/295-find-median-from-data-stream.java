class MedianFinder { 
   /**
   * * TC: O(log n)
   * * SC: O(n)
   */
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double median = 0;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int number) {
          // Write your code here.
      if (maxHeap.isEmpty() || number < maxHeap.peek()) maxHeap.add(number);
      else minHeap.add(number);

      reBalanceHeaps();
      updateMedian();
    }
    
    public double findMedian() {
          return median;
    }
    
    private void reBalanceHeaps() {
      if (maxHeap.size() - minHeap.size() == 2) minHeap.add(maxHeap.poll());
      else if (minHeap.size() - maxHeap.size() == 2) maxHeap.add(minHeap.poll());
    }

    private void updateMedian() {
      if (maxHeap.size() == minHeap.size()) calcEvenMedian();
      else calcOddMedian();
    }

    private void calcEvenMedian() {
      median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }

    private void calcOddMedian() {
      median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */