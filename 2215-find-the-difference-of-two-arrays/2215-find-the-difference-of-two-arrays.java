import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        ArrayList<List<Integer>> mainlist = new ArrayList<>();

        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for (int num : nums1) {
            hs1.add(num);
        }
        for (int num : nums2) {
            hs2.add(num);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int key : hs1){
            if(!hs2.contains(key)){
                list1.add(key);
            }
            
        } 
        for (int key : hs2){
            if(!hs1.contains(key)){
                list2.add(key);
            }
            
        } 
            

        mainlist.add(list1);
        mainlist.add(list2);

        return mainlist;
    }
}
