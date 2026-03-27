class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<=s.length()-p.length();i++){
           
            
                String k=s.substring(i,i+p.length());
            
            if(isanagram(k,p)){
                res.add(i);
            }
        }
        return res;
       
        
    }
    public boolean isanagram(String a,String b){
        int[]arr=new int[26];
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-'a']++;
            arr[b.charAt(i)-'a']--;
        }
        for(int n:arr){
            if(n!=0){
                return false;
            }
        }
        return true;
    }
}