class Solution {
    
    private String getfreqstring(String str){
        
        int[] freq=new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }
        
        StringBuilder st=new StringBuilder("");
           char c='a';
        for(int i:freq){
            st.append(c);
            st.append(i);
            c++;
        }
        return st.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }
        
        Map<String,List<String>> map=new HashMap<>();
        for(String str: strs){
            String freqstring=getfreqstring(str);
            
            if(map.containsKey(freqstring)){
                map.get(freqstring).add(str);
            }
            else{
                List<String> strlist=new ArrayList<>();
                strlist.add(str);
                map.put(freqstring,strlist);
            }
        }
        return new ArrayList<>(map.values());
    }
}