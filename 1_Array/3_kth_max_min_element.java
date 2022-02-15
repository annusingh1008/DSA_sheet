class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Approach 1
        // TC - O(nlogn)  SC - O(1) - constant
        Arrays.sort(arr);
        return arr[k-1];
    } 

    //Appraoch 2 - using priority queue
    // java ByDefault -> minHeap
    // kthSmallest
    // TC - O(nlogk)
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap   
    for(int i = 0; i < k; i++){
        pq.add(arr[i]);
    }
    
    for(int i = k; i < arr.length; i++){
        if(arr[i] < pq.peek()){
            pq.poll();
            pq.add(arr[i]);
        }
    }
    return pq.peek();

    // kthLargest
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // minHeap   
    for(int i = 0; i < k; i++){
        pq.add(arr[i]);
    }
    
    for(int i = k; i < arr.length; i++){
        if(arr[i] > pq.peek()){
            pq.poll();
            pq.add(arr[i]);
        }
    }
    return pq.peek();

    //using single loop - kth smallest element
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = l; i <= r; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();

}
