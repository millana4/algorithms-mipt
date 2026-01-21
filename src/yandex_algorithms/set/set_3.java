package yandex_algorithms.set;

import java.util.HashSet;
import java.util.Scanner;

public class set_3 {
    public static void main(String[] args) {
        HashSet<Integer> intersection = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        boolean firstSet = true;
        
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            
            for (int j = 0; j < k; j++) {
                set.add(scanner.nextInt());
            }
            
            if (firstSet) {
                intersection.addAll(set);
                firstSet = false;
            } else {
                intersection.retainAll(set);
            }
        }
        scanner.close();
        
        System.out.println(intersection.size());
    }
}