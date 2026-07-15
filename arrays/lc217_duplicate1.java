import java.util.HashSet;

public class lc217_duplicate1 {
     HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
    
}
