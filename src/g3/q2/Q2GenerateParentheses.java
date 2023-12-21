package g3.q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // 当前字符串长度达到2n，即括号组合完成
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        // 左括号数量小于n，可以添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 右括号数量小于左括号数量，可以添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入括号对数 n：");
        int n = input.nextInt();
        input.close();

        List<String> result = generateParentheses(n);
        System.out.println(result);
    }
}