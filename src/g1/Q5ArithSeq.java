package g1;

public class Q5ArithSeq {

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 7, 8, 10};
    System.out.println(getMaxLength(nums));
  }

  private static int getMaxLength(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int diff = nums[j] - nums[i];
        int currentLength = 2;
        int previous = nums[j];
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[k] - previous == diff) {
            currentLength++;
            previous = nums[k];
          }
        }
        result = Math.max(result, currentLength);
      }
    }
    return result;
  }

}
