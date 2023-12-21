package g1;

public class Q4EditDistance {

  public static void main(String[] args) {
    String word1 = "intention";
    String word2 = "execution";
    System.out.println("输入：word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
    System.out.println("输出: " + getMinDistance(word1, word2));
  }

  public static int getMinDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    // 有一个字符串为空串
    if (n * m == 0) {
      return n + m;
    }

    // DP 数组
    int[][] dp = new int[n + 1][m + 1];

    // 边界状态初始化
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
      dp[0][j] = j;
    }

    // 计算所有 DP 值
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, // 替换
              Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)); // 删除、添加
        }
      }

    }
    return dp[n][m];
  }

}

