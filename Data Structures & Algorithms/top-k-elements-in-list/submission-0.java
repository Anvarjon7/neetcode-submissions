class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)
                                                          -> freq.get(a) - freq.get(b));

        for(int num : freq.keySet()){
            heap.offer(num);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!heap.isEmpty()){
            res[i] = heap.poll();
            i++;
        }

        return res;
    }
}
