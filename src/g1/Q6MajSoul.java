package g1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q6MajSoul {

  public static void main(String[] args) {
    // 输入你有的牌
    Scanner scanner = new Scanner(System.in);
    int[] brandsYouHaveCounter = new int[10];
    for (int i = 1; i <= 13; i++) {
      int brand = scanner.nextInt();
      brandsYouHaveCounter[brand]++;
    }

    // 看看还能用哪些牌
    List<Integer> brandsCanUse = new ArrayList<>();
    for (int brand = 1; brand <= 9; brand++) {
      if (brandsYouHaveCounter[brand] < 4) {
        brandsCanUse.add(brand);
      }
    }

    // 把能用的牌依次加进来试试
    List<Integer> result = new ArrayList<>();
    for (Integer brandAdded : brandsCanUse) {
      // 加进一张牌，看看能不能胡
      brandsYouHaveCounter[brandAdded]++;
      // 如果能胡，就把这张牌加入结果集
      if (isHu(brandsYouHaveCounter)) {
        result.add(brandAdded);
      }
      // 拿走这张牌，进行下次尝试
      brandsYouHaveCounter[brandAdded]--;
    }

    // 输出结果
    if (result.isEmpty()) {
      System.out.println(0);
    } else {
      for (Integer brand : result) {
        System.out.print(brand + " ");
      }
    }
  }

  private static boolean isHu(int[] brandsCount) {
    return pickOutHeadBrands(Arrays.copyOf(brandsCount, brandsCount.length));
  }

  private static boolean pickOutHeadBrands(int[] brandsCount) {
    // 选出所有的候选雀头
    List<Integer> headBrands = new ArrayList<>();
    for (int brand = 1; brand <= 9; brand++) {
      // 如果该牌有两张以上，就可以作为雀头
      if (brandsCount[brand] >= 2) {
        headBrands.add(brand);
      }
    }

    // 一个一个尝试
    for (int headBrand : headBrands) {
      brandsCount[headBrand] -= 2;
      if (pickOutOtherBrands(brandsCount)) {
        return true;
      }
      brandsCount[headBrand] += 2;
    }
    return false;
  }

  // TODO: 记录牌的数量，最后判断的时候可以不用每次都遍历一遍
  private static boolean pickOutOtherBrands(int[] brandsCount) {
    for (int brand = 1; brand <= 9; brand++) {
      if (brandsCount[brand] == 0) {
        continue;
      }

      // 刻子
      if (brandsCount[brand] >= 3) {
        brandsCount[brand] -= 3;
        if (pickOutOtherBrands(brandsCount)) {
          return true;
        }
        brandsCount[brand] += 3;
      }

      if (brand <= 7 && brandsCount[brand] > 0 && brandsCount[brand + 1] > 0
          && brandsCount[brand + 2] > 0) {
        brandsCount[brand]--;
        brandsCount[brand + 1]--;
        brandsCount[brand + 2]--;
        if (pickOutOtherBrands(brandsCount)) {
          return true;
        }
        brandsCount[brand]++;
        brandsCount[brand + 1]++;
        brandsCount[brand + 2]++;
      }
    }

    for (int i = 1; i <= 9; i++) {
      if (brandsCount[i] > 0) {
        return false;
      }
    }
    return true;
  }

}
