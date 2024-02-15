class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> s=new Stack<>();
        
        for(int i=0;i<parts.length;i++){
            if(parts[i].equals("") || parts[i].equals(".")){
                continue;
            }
            else if(parts[i].equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else{
                s.push(parts[i]);
            }
        }
        
        String res="";
        if(s.isEmpty()){
            return "/";
        }
        else{
            while(!s.isEmpty()){
                res="/"+s.pop()+res;
            }
        }
        return res;
    }
}