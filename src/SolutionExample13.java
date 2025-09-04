import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vladimir_shi
 * @since 04.09.2025
 * ------------------------------
 * Intersection of Two Arrays II
 * ------------------------------
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 * Each element in the result must appear as many times as it shows
 * in both arrays, and you may return the result in any order.
 */

public class SolutionExample13 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i : nums1) {
            int index2 = Arrays.binarySearch(nums2, i);
            if (index2 >= 0){
                list.add(nums2[index2]);
                nums2[index2] = -1;
                Arrays.sort(nums2);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

