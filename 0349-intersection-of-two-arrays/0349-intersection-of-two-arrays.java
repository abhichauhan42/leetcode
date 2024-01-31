class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(Integer i: nums1){
            hs1.add(i);
        }
        
        for(Integer i: nums2){
            hs2.add(i);
        }
    
        ArrayList<Integer> list=new ArrayList<>();
        for(Integer key: hs1){
            if(hs2.contains(key)){
                list.add(key);
            }
        }
        
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
    
        
        return arr;
        
    }
}