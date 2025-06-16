
//Given a 0-indexed integer array nums of size n, find the maximum difference
// between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
//Return the maximum difference. If no such i and j exists, return -1.

import java.util.Scanner;

public class SolutionExample2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = convertStrToInt(scanner.nextLine());
        int result = maximumDifference(array);
        System.out.println(result);
    }

    /**
     * Конвертация строки чисел в массив чисел (int).
     *
     * @param string - строка чисел введенных через пробел.
     * @return - возврат массива чисел.
     */
    private static int[] convertStrToInt(String string) {
        String[] arrayStr = string.split(" ");
        int[] arrayInt = new int[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            arrayInt[i] = Integer.parseInt(arrayStr[i]);
        }
        return arrayInt;
    }

    /**
     * Поиск максимальной разницы двух чисел из массива, если i < j и nums[i] < nums[j].
     *
     * @param nums - массив чисел
     * @return - максимальная разница, либо -1 при отсутствии таковой.
     */
    private static int maximumDifference(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j] && i < j) {
                    int maxNum = nums[j] - nums[i];
                    if (maxNum > maxDiff) {
                        maxDiff = maxNum;
                    }
                }
            }
        }
        if (maxDiff > 0) {
            return maxDiff;
        } else {
            return -1;
        }
    }
}
