package g2.q3;

import java.util.Scanner;

public class Q3SearchComp {
    // 二分查找算法
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // 三分查找算法
    public static int ternarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }

            if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入有序数组元素个数：");
        int size = input.nextInt();
        int[] arr = new int[size];

        System.out.println("请输入有序数组元素：");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("请输入目标元素：");
        int target = input.nextInt();
        int binaryResult = binarySearch(arr, target);
        int ternaryResult = ternarySearch(arr, target);

        System.out.println("二分查找结果: " + binaryResult);
        System.out.println("三分查找结果: " + ternaryResult);
    }
}
