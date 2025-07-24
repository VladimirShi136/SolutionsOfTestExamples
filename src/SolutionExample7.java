import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

// 54. Spiral Matrix
// Given an m x n matrix, return all elements of the matrix in spiral order.

public class SolutionExample7 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int lengthMatrix = matrix.length * matrix[0].length;
        int turn = 0;
        int x = 0;
        int y = 0;
        boolean flag = true;
        while (lengthMatrix > 0) {
            if (turn % 2 == 0 && flag) {
                while (y < matrix[0].length) {
                    if (set.contains(x + "," + y)) {
                        break;
                    } else {
                        set.add(x + "," + y);
                    }
                    result.add(matrix[x][y]);
                    lengthMatrix--;
                    if (lengthMatrix == 0) {
                        break;
                    }
                    y++;
                }
                flag = false;
                y--;
                x++;
            } else if (turn % 2 == 0 && !flag) {
                while (x < matrix.length) {
                    if (set.contains(x + "," + y)) {
                        break;
                    } else {
                        set.add(x + "," + y);
                    }
                    result.add(matrix[x][y]);
                    lengthMatrix--;
                    if (lengthMatrix == 0) {
                        break;
                    }
                    x++;
                }
                turn++;
                x--;
                y--;
            } else if (turn % 2 != 0 && !flag) {
                while (y >= 0) {
                    if (set.contains(x + "," + y)) {
                        break;
                    } else {
                        set.add(x + "," + y);
                    }
                    result.add(matrix[x][y]);
                    lengthMatrix--;
                    if (lengthMatrix == 0) {
                        break;
                    }
                    y--;
                }
                flag = true;
                y++;
                x--;
            } else if (turn % 2 != 0 && flag) {
                while (x >= 0) {
                    if (set.contains(x + "," + y)) {
                        break;
                    } else {
                        set.add(x + "," + y);
                    }
                    result.add(matrix[x][y]);
                    lengthMatrix--;
                    if (lengthMatrix == 0) {
                        break;
                    }
                    x--;
                }
                turn++;
                x++;
                y++;
            }
        }
        return result;
    }
}
