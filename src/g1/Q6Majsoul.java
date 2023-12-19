package g1;

import java.util.*;

public class Q6Majsoul {

    private static final int[] brandsCountLeft = new int[10];

    static {
        for (int brand = 1; brand <= 9; brand++) {
            brandsCountLeft[brand] = 4;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入你有的牌
        int[] brandsCountYouHave = new int[10];
        for (int i = 1; i <= 13; i++) {
            int brand = scanner.nextInt();
            brandsCountYouHave[brand]++;
            brandsCountLeft[brand]--;
        }

        // 看看还能用哪些牌
        List<Integer> brandsCanUse = new ArrayList<>();
        for (int brand = 0; brand < brandsCountLeft.length; brand++) {
            if (brandsCountLeft[brand] > 0) {
                brandsCanUse.add(brand);
            }
        }

        // 把能用的牌依次加进来试试，如果能胡，就把这张牌加入结果集
        List<Integer> result = new ArrayList<>();
        for (Integer brand : brandsCanUse) {
            // 加进一张牌，看看能不能胡
            brandsCountYouHave[brand]++;
            if (isHu(brandsCountYouHave)) {
                result.add(brand);
            }
            // 拿走这张牌，进行下次尝试
            brandsCountYouHave[brand]--;
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
        return pickUpHead(Arrays.copyOf(brandsCount, brandsCount.length));
    }

    private static boolean pickUpHead(int[] brandsCount) {
        // 选出所有的雀头
        List<Integer> headBrands = new ArrayList<>();
        for (int brand = 1; brand <= 9; brand++) {
            if (brandsCount[brand] >= 2) {
                headBrands.add(brand);
            }
        }

        // 一个一个尝试
        for (int headBrand : headBrands) {
            brandsCount[headBrand] -= 2;
            if (pickUpOthers(brandsCount)) {
                return true;
            }
            brandsCount[headBrand] += 2;
        }
        return false;
    }

    private static boolean pickUpOthers(int[] brandsCount) {
        for (int brand = 1; brand <= 9; brand++) {
            if (brandsCount[brand] == 0) {
                continue;
            }

            if (brandsCount[brand] >= 3) {
                brandsCount[brand] -= 3;
                if (pickUpOthers(brandsCount)) {
                    return true;
                }
                brandsCount[brand] += 3;
            }

            if (brand <= 7 && brandsCount[brand] > 0 && brandsCount[brand + 1] > 0 && brandsCount[brand + 2] > 0) {
                brandsCount[brand]--;
                brandsCount[brand + 1]--;
                brandsCount[brand + 2]--;
                if (pickUpOthers(brandsCount)) {
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
