package yandex_algorithms.fifth_technics;

import java.util.Arrays;
import java.util.Scanner;

public class brute_force_4_password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nk_str = scanner.nextLine();
        String[] parts = nk_str.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        String nums_str = scanner.nextLine();
        String[] parts_nums = nums_str.split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts_nums[i]);
        }

        // минимальное число = цифры по возрастанию
        Arrays.sort(nums);

        boolean found = false;
        do {
            long password = 0;
            for (int i = 0; i < n; i++) {
                password = password * 10 + nums[i];
            }

            if (password % m == 0) {
                StringBuilder comb = new StringBuilder();
                for (int d : nums) comb.append(d);
                System.out.print(comb);
                found = true;
                break;
            }
        } while (nextPermutation(nums));

        if (!found) {
            System.out.print("No solutions");
        }
    }

    // переход к следующей перестановке по возрастанию; false если её нет
    public static boolean nextPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;

        int j = a.length - 1;
        while (a[j] <= a[i]) j--;

        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;

        int left = i + 1, right = a.length - 1;
        while (left < right) {
            int t = a[left]; a[left] = a[right]; a[right] = t;
            left++; right--;
        }
        return true;
    }
}