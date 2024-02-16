import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int majorityElement = 0;
        int maxOccurrences = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                majorityElement = entry.getKey();
                maxOccurrences = entry.getValue();
            }
        }

        return majorityElement;
    }
}
