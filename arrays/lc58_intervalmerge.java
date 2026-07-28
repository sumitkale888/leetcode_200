public class lc58_intervalmerge {
    
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]>ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[]last=ans.get(ans.size()-1);
            if(intervals[i][0]<=last[1]){
                last[1]=Math.max(last[1],intervals[i][1]);
            }else{
                ans.add(intervals[i]);
            }

        }
        return ans.toArray(new int[ans.size()][]);
        
    }

}

// time nlonn

// Approach
// Sort the intervals based on their start time.
// Initialize a result list with the first interval.
// Traverse the remaining intervals:
// If the current interval overlaps with the last interval in the result, merge them by updating the end.
// Otherwise, add the current interval to the result.
// Convert the list back to a 2D array.