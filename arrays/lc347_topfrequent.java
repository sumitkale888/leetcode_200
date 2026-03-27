import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    //store frequency
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
            map.put(nums[i],1);
            }
        }

        //store element with their frequency in bucket

        //arr of list

        List<Integer>[]bucket=new List[nums.length+1];//Array index 0 se start hota hai,
        for(int key:map.keySet()){
            int fre=map.get(key);
            if(bucket[fre]==null){
                bucket[fre]=new ArrayList<>();
            }
            bucket[fre].add(key);
        }

        //collect top k

        int[]res=new int[k];
        int c=0;

        for(int i=bucket.length-1;i>=0&&c<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    res[c++]=num;
                    if(c==k)break;
                }
            }
        }
        return res;
    }
}

// Step 1: Frequency Count (HashMap)

// Har number ki frequency count karo.

// Store in map<number, frequency>

// map.put(num, map.getOrDefault(num, 0) + 1);

// Time: O(n)

// 🧠 Step 2: Bucket Creation
// List<Integer>[] bucket = new List[nums.length + 1];

// Index = frequency

// Value = list of numbers having that frequency

// Max frequency = nums.length

// Isliye size = n + 1

// Example:

// freq = 3 → bucket[3] me number store hoga

// Time: O(n)

// 🧠 Step 3: Collect Top K

// Bucket ko end se traverse karo (high freq → low freq)

// Elements collect karo jab tak k complete na ho

// Time: O(n)

// ⏱ Total Complexity

// | Time | O(n) |
// | Space | O(n) |

// 📦 Data Flow
// nums → HashMap (frequency)
//      → Bucket (frequency index)
//      → Traverse reverse
//      → Top K result
// 💡 One-Line Intuition

// Pehle count karo, phir frequency ke according group karo, phir highest frequency se pick karo.