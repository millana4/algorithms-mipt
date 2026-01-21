package yandex_algorithms.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class set_4_sunflower {
    public static void main(String[] args) {
        HashSet<Integer> intersection = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean firstSet = true;

        List<Set<Integer>> listOfSets = new ArrayList<>();
                
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
                    
            for (int j = 0; j < k; j++) {
                int element = scanner.nextInt();  
                set.add(element);
            }

            listOfSets.add(set);
                    
            if (firstSet) {
                intersection.addAll(set);
                firstSet = false;
            } else {
                intersection.retainAll(set);
            }
        }
        scanner.close();

        int cKerner = intersection.size();

        // ✔ НОВАЯ ПРОВЕРКА ЛЕПЕСТКОВ
        HashSet<Integer> petalsUnion = new HashSet<>();
        boolean ok = true;

        for (Set<Integer> s : listOfSets) {
            for (int x : s) {
                if (!intersection.contains(x)) {
                    if (!petalsUnion.add(x)) {
                        ok = false; // лепестки пересеклись
                        break;
                    }
                }
            }
            if (!ok) break;
        }

        if (ok) {
            StringBuilder petals = new StringBuilder();   
            for (Set<Integer> nextSet : listOfSets) {    
                petals.append(nextSet.size() - cKerner).append(" ");
            }

            System.out.println("YES");
            System.out.println(cKerner);
            System.out.println(petals.toString().trim());  
        } else {
            System.out.println("NO"); 
        }
    }
}