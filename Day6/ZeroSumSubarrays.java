
import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        // Put prefix sum 0 at index -1 (to handle subarray starting from 0)
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefixSum already seen, subarray(s) exist
            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Add current index to map
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Print result in (start, end) format
        for (int[] sub : subarrays) {
            System.out.println("(" + sub[0] + ", " + sub[1] + ")");
        }
    }
}
