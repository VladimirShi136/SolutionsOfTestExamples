import java.util.Arrays;

// 498. Diagonal Traverse
// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.



public class SolutionExample8 {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}}; // 4 X 5
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};                                                 // 3 X 3
        int[][] mat3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};   // 5 x 4
        int[][] mat5 = {{1, 2}, {3, 4}}; // 2 x 2
        int[][] mat6 = {{1, 2}}; // 1 x 2
        int[][] mat7 = {{1,2}, {3,4}, {5,6}, {7,8}, {9,10}}; // 5 x 2

        int[] result = findDiagonalOrder(mat1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int count = 0;
        int i = 0;
        int j = 0;
        boolean turn = true;

        if (mat.length == 1) {
            return mat[0];
        }

        if (mat[0].length == 1) {
            for (int k = 0; k < mat.length; k++) {
                result[k] = mat[k][0];
            }
            return result;
        }

        while (count != result.length) {
            boolean flag = true;
            if (i == 0 && j == 0) {
                result[count] = mat[i][j];
                count++;
                j++;
            } else if (turn) { // вниз и влево
                while (flag) {
                    result[count] = mat[i][j];
                    count++;
                    i++;
                    j--;

                    if (count == result.length) {
                        return result;
                    }

                    if (j == i) {
                        result[count] = mat[i][j];
                        count++;
                        i++;
                        j--;
                    }

                    if (j == 0 || i == mat.length - 1) {
                        result[count] = mat[i][j];
                        count++;
                        if (i == mat.length - 1) {
                            j++;
                        } else {
                            i++;
                        }
                        flag = false;
                        turn = false;
                    }
                }
            } else if (!turn || (j == i && i == mat.length - 1)) { // вверх и вправо
                while (flag) {
                    result[count] = mat[i][j];
                    count++;
                    i--;
                    j++;

                    if (count == result.length) {
                        return result;
                    }

                    if (j == i) {
                        result[count] = mat[i][j];
                        count++;
                        if (j >= mat[0].length - 1) {
                            i++;
                            flag = false;
                            turn = true;
                            break;
                        } else {
                            i--;
                            j++;
                        }
                    }

                    if (i == 0 || j == mat[0].length - 1) {
                        result[count] = mat[i][j];
                        count++;
                        if (j == mat[0].length - 1) {
                            i++;
                        } else {
                            j++;
                        }
                        flag = false;
                        turn = true;
                    }
                }
            }
        }
        return result;
    }
}
