import java.util.*;

public class BracketsCheckService {

    public static String getValidBracketsString(String string) {
        if (string.isBlank()) return "0";

        Stack<Integer> incorrectBracketsIndexes = new Stack<>();
        StringBuilder clearString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                incorrectBracketsIndexes.push(i);
            } else if (!incorrectBracketsIndexes.isEmpty() && string.charAt(incorrectBracketsIndexes.peek()) == '(') {
                incorrectBracketsIndexes.pop();
            } else {
                incorrectBracketsIndexes.push(i);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (!incorrectBracketsIndexes.contains(i)) {
                clearString.append(string.charAt(i));
            }
        }
        return clearString.length() == 0 ? "0" : clearString.toString();
    }
}
