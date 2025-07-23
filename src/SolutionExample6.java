//1717. Maximum Score From Removing Substrings
//You are given a string s and two integers x and y.
//You can perform two types of operations any number of times.
//Remove substring "ab" and gain x points.
//For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//Remove substring "ba" and gain y points.
//For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//Return the maximum points you can gain after applying the above operations on s.

public class SolutionExample6 {
    public static void main(String[] args) {
        String s = "aabbaaxybbaabb";
        int x = 5; //ab
        int y = 4; //ba
        int result = maximumGain(s, x, y);
        System.out.println(result);
    }

    private static int maximumGain(String s, int x, int y) {
        StringBuilder text = new StringBuilder(s);
        int quantity = 0;

        for (int j = 0; j < 2; j++) {
            if (x > y) {
                for (int i = text.length() - 1; i > 0; i--) {
                    String word = text.substring(i - 1, i + 1);
                    if (word.equals("ab")) {
                        quantity += x;
                        text.delete(i - 1, i + 1);
                        i += 2;
                        if (i >= text.length() + 1) {
                            i = text.length();
                        }
                    }
                }
                x = 0;
            } else {
                for (int i = text.length() - 1; i > 0; i--) {
                    String word = text.substring(i - 1, i + 1);
                    if (word.equals("ba")) {
                        quantity += y;
                        text.delete(i - 1, i + 1);
                        i += 2;
                        if (i >= text.length() + 1) {
                            i = text.length();
                        }
                    }
                }
                y = 0;
            }
        }
        return quantity;
    }
}
