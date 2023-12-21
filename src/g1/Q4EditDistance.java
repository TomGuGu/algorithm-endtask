package g1;

public class Q4EditDistance {
    private static StringBuilder steps = new StringBuilder(); // 用于保存编辑步骤

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
        int[][] D = new int[n + 1][m + 1];
        int[][] prev = new int[n + 1][m + 1]; // 记录转移来源

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                if (left <= down && left <= left_down) {
                    D[i][j] = left;
                    prev[i][j] = 1; // 来自左边的转移
                } else if (down <= left && down <= left_down) {
                    D[i][j] = down;
                    prev[i][j] = 2; // 来自上边的转移
                } else {
                    D[i][j] = left_down;
                    prev[i][j] = 3; // 来自左上方的转移
                }
            }
        }

        // 回溯找到具体的编辑步骤
        int i = n;
        int j = m;
        while (i > 0 || j > 0) {
            if (prev[i][j] == 1) {
                steps.append("删除 ").append(word1.charAt(i - 1));
                i--;
            } else if (prev[i][j] == 2) {
                steps.append("添加 ").append(word2.charAt(j - 1));
                j--;
            } else {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    steps.append("将").append(word1.charAt(i - 1)).append("替换为").append(word2.charAt(j - 1));
                }
                i--;
                j--;
            }

        }

        System.out.println(steps);
        return D[n][m];
    }

}

