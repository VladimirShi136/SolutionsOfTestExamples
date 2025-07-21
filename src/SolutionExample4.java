import java.util.Scanner;

//1957. Delete Characters to Make Fancy String
//A fancy string is a string where no three consecutive characters are equals.
//Given a string s, delete the minimum possible number of characters from s to make it fancy.
//Return the final string after the deletion. It can be shown that the answer will always be unique.

public class SolutionExample4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String newText = makeFancyString(text);
        System.out.println(newText);
    }

    public static String makeFancyString(String text) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        char symbol = stringBuilder.charAt(0);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == symbol) {
                count++;
                if (count >= 3) {
                    stringBuilder.deleteCharAt(i);
                    i--;
                }
            } else {
                count = 0;
                symbol = stringBuilder.charAt(i);
                i--;
            }
        }
        return String.join("", stringBuilder);
    }
}
