package g1;

import java.util.Scanner;

public class Q7WildcardMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串 s：");
        String s = scanner.nextLine();
        System.out.print("请输入字符模式 p：");
        String p = scanner.nextLine();

        boolean isMatch = isMatch(s, p);

        System.out.println("是否能匹配：" + isMatch);

        scanner.close();
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 创建一个二维数组用于存储匹配结果
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化边界条件
        dp[0][0] = true;

        // 处理模式串开头的连续 '*' 的情况
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 动态规划计算匹配结果
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
