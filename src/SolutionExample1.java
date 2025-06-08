import java.util.*;

// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
// You must write an algorithm that runs in O(n) time and uses O(1) extra space.

public class SolutionExample1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Print a number: ");
        int n = scanner.nextInt();
        System.out.println(lexicalOrder(n));

    }

    public static List<Integer> lexicalOrder(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1 + "";
        }
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        for (String s : arr) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}

