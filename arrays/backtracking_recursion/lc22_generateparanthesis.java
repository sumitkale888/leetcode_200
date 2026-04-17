class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        generate(ans,n,0,0,"");
        return ans;
        
    }
    public void generate(List<String>res,int n,int o,int c,String unp){
        if(unp.length()==2*n){
            res.add(unp);
            return;
        }
        if(o<n){
           generate(res,n,o+1,c,unp+'(');
        }
         if(c<o){
           generate(res,n,o,c+1,unp+")");
        }
    }
}