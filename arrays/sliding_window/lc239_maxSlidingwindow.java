class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        List<Integer>ans=new ArrayList<>();
        int[] a=new int[n-k+1];

        for(int i=0;i<=n-k;i++){
            for(int j=i;j<i+k;j++){
                pq.add(nums[j]);
              
            }
            a[i]=pq.poll();
              while(!pq.isEmpty()){
                    pq.poll();
                }
            


        }
        return a;
        

       
        }

    }

    // brutforce