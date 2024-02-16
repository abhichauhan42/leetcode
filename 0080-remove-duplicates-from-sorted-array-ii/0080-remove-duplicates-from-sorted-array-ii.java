import java.util.HashMap;

class Solution {
  public int removeDuplicates(int[] nums) {
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (map.get(num) <= 2) { 
        nums[count++] = num;
      }
    }

    return count;
  }
}
