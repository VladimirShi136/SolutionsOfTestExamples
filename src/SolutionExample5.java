import java.util.HashMap;

//219. Contains Duplicate II
//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in
//the array such that nums[i] == nums[j] and abs(i - j) <= k.

public class SolutionExample5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /* Хеш карта позволяет увидеть в массиве дубликаты и сверить их по условию, вместо поиска по массиву
    через цикл путем пробега по всему массиву */

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                j = map.get(nums[i]);
                if ((nums[i] == nums[j]) && (Math.abs(i - (j)) <= k)) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
