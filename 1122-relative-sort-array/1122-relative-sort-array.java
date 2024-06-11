class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         // Step 1: Create a frequency count for arr1
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int num : arr1) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a result list and populate it with elements from arr2
        List<Integer> resultList = new ArrayList<>();
        for (int num : arr2) {
            if (freqCount.containsKey(num)) {
                int count = freqCount.get(num);
                for (int i = 0; i < count; i++) {
                    resultList.add(num);
                }
                freqCount.remove(num); // Remove the element from the frequency count once added
            }
        }

        // Step 3: Collect and sort the remaining elements not in arr2
        List<Integer> remainingElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remainingElements.add(num);
            }
        }

        Collections.sort(remainingElements); // Sort remaining elements in ascending order

        // Step 4: Combine the lists
        resultList.addAll(remainingElements);

        // Convert the result list to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}