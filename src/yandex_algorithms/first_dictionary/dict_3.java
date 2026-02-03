package yandex_algorithms.first_dictionary;

import java.util.HashMap;
import java.util.Scanner;

public class dict_3 {
    public static void main(String[] args) {
        HashMap<Float, Integer> dict = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int maxCount = 0;
        float bestFraction = Float.MAX_VALUE;
        int bestNumerator = 0;
        int bestDenominator = 0;

        for (int i = 0; i < n; i++) {
            String request = scanner.nextLine();
            String[] parts = request.split(" ");

            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            
            // Сокращаем дробь
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            
            float value = (float) numerator / denominator;
            Integer count = dict.get(value);

            if (count == null) {
                count = 1;
            } else {
                count = count + 1;
            }
            
            dict.put(value, count);
            
            // Обновляем лучшую дробь
            if (count > maxCount || (count == maxCount && value < bestFraction)) {
                maxCount = count;
                bestFraction = value;
                bestNumerator = numerator;
                bestDenominator = denominator;
            }
        }

        System.out.println(bestNumerator + " " + bestDenominator);
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}