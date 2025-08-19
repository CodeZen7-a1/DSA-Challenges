
import java.util.*;

public class LeadersInArray {

    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();

        // Start from the rightmost element
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);

        // Traverse array from second last element to the left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // Reverse the result to keep original order
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders: " + findLeaders(arr));
    }
}
