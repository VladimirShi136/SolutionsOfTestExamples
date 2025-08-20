import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vladimir_shi
 * @since 20.08.2025
 *
 * 189. Rotate Array
 * Given an integer array nums,
 * rotate the array to the right by k steps, where k is non-negative.
 */

public class SolutionExample10 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 7;
        rotate(nums, k);
    }

    private static void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        int[] firstArr = Arrays.copyOfRange(nums, getIndex(nums, k), nums.length);
        int[] secondArr = Arrays.copyOf(nums, getIndex(nums, k));
        List<Integer> list = new ArrayList<>();
        for (Integer i : firstArr) {
            list.add(i);
        }
        for (Integer i : secondArr) {
            list.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        System.out.println(Arrays.toString(nums));
    }

    private static int getIndex(int[] nums, int k) {
        int result = 0;
        if (nums.length > k) result = nums.length - k;
        if (nums.length < k) result = nums.length - (k % nums.length);
        return result;
    }
}

