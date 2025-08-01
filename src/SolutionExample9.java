import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 67. Add Binary
// Given two binary strings a and b, return their sum as a binary string.

public class SolutionExample9 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "101";
        String result = addBinary(a, b);
        System.out.println(result);
    }

    private static String addBinary(String a, String b) {
        List<String> list1 = new ArrayList<>(Arrays.stream(a.split("")).toList());
        List<String> list2 = new ArrayList<>(Arrays.stream(b.split("")).toList());
        List<String> resultList = new ArrayList<>();
        int size;
        int reserve = 0;

        if (list1.size() > list2.size()) {
            size = list1.size() - list2.size();
            for (int i = 0; i < size; i++) {
                list2.addFirst("0");
            }
        } else if (list1.size() < list2.size()) {
            size = list2.size() - list1.size();
            for (int i = 0; i < size; i++) {
                list1.addFirst("0");
            }
        }

        for (int i = list1.size() - 1; i >= 0 ; i--) {
            int sum = Integer.parseInt(list1.get(i)) + Integer.parseInt(list2.get(i)) + reserve;
            reserve = switch (sum) {
                case 0 -> {
                    resultList.addFirst("0");
                    yield 0;
                }
                case 1 -> {
                    resultList.addFirst("1");
                    yield 0;
                }
                case 2 -> {
                    resultList.addFirst("0");
                    yield 1;
                }
                case 3 -> {
                    resultList.addFirst("1");
                    yield 1;
                }
                default -> reserve;
            };
        }

        if (reserve == 1) {
            resultList.addFirst("1");
        }

        return String.join("", resultList);
    }
}