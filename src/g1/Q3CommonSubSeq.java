package g1;


public class Q3CommonSubSeq {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("输入：word1 = \"" + text1 + "\", word2 = \"" + text2 + "\"");
        System.out.println("最长公共子序列的长度: " + getMaxLength(text1, text2));
    }

    public static int getMaxLength(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
