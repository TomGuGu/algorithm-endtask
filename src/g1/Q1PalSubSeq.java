package g1;

public class Q1PalSubSeq {

  public static void main(String[] args) {
    // 5, bcbcb
    String str = "abcbkaefcbc";
    System.out.println(getMaxLength(str, 0, str.length() - 1));
  }

  private static int getMaxLength(String str, int i, int j) {
    if (i == j) {
      return 1;
    }
    if (i > j) {
      return 0;
    }
    if (str.charAt(i) == str.charAt(j)) {
      return 2 + getMaxLength(str, i + 1, j - 1);
    } else {
      return Math.max(getMaxLength(str, i + 1, j), getMaxLength(str, i, j - 1));
    }
  }

}
