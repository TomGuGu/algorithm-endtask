package g1;

public class Q5ArithSeq {

    private static int[] nums = {1, 3, 4, 7, 8, 10};

    public static void main(String[] args) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int diff = nums[j] - nums[i];
                int currentLength = 2;
                int previous = nums[j];
                for (int k = j + 1; k < length; k++) {
                    if (nums[k] - previous == diff) {
                        currentLength++;
                        previous = nums[k];
                    }
                }
                result = Math.max(result, currentLength);
            }
        }

        System.out.println(result);
    }

}
