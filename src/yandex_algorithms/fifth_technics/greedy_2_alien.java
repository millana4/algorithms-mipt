package yandex_algorithms.fifth_technics;

import java.util.Scanner;

public class greedy_2_alien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String signal = scanner.nextLine();
        String alien = scanner.nextLine();

        boolean flag = false;
        for (int i = 0; i <= signal.length() - alien.length(); i++) {
            int j = 0;
            for (j = 0; j < alien.length(); j++) {
                if (signal.charAt(i + j) != alien.charAt(j)) {
                    break;
                }
            }

            if (j == alien.length()) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
