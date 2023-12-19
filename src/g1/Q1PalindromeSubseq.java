package g1;

public class Q1PalindromeSubseq {

    private static String str = "abcxcbc";

    public static void main(String[] args) {
        System.out.println(calc(0, str.length() - 1));
    }

    //i,j都是下标
    private static int calc(int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (str.charAt(i) == str.charAt(j)) {
            return 2 + calc(i + 1, j - 1);
        } else {
            return Math.max(calc(i + 1, j), calc(i, j - 1));
        }
    }

}
