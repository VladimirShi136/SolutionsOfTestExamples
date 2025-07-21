
import java.util.*;

public class SolutionExample3 {
    public static void main(String[] args) {
        int[] nums = createArray();
        System.out.println(check(nums));
    }

    private static boolean check(int[] nums) {
        int first = nums[0];
        if (nums[0] < nums[nums.length-1]){
            System.out.println(Arrays.toString(nums));
            return true;
        }
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        while (first > 0) {
            Integer num = list.removeFirst();
            list.add(list.size(), num);
            first--;
        }
        System.out.println(list);
        return list.getFirst() < list.get(list.size()-1);
    }

    private static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Integer.parseInt(nums[i]);
        }
        return result;
    }
}
