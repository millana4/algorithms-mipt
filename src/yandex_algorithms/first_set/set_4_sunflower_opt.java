package yandex_algorithms.first_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FastScanner {
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int readByte() {
        if (ptr >= len) {
            try {
                len = System.in.read(buffer);
                ptr = 0;
            } catch (Exception e) {
                return -1;
            }
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    int nextInt() {
        int c;
        while ((c = readByte()) <= ' ') ;
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = readByte();
        }
        int val = 0;
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }
}

public class set_4_sunflower_opt {
    public static void main(String[] args) {
        HashSet<Integer> intersection = new HashSet<>();
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();

        boolean firstSet = true;
        List<Set<Integer>> listOfSets = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>(k * 2);

            for (int j = 0; j < k; j++) {
                set.add(scanner.nextInt());
            }

            listOfSets.add(set);

            if (firstSet) {
                intersection.addAll(set);
                firstSet = false;
            } else {
                intersection.retainAll(set);
            }
        }

        int cKerner = intersection.size();

        // проверка лепестков
        HashSet<Integer> petalsUnion = new HashSet<>();
        boolean ok = true;

        for (Set<Integer> s : listOfSets) {
            for (int x : s) {
                if (!intersection.contains(x)) {
                    if (!petalsUnion.add(x)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) break;
        }

        if (ok) {
            StringBuilder petals = new StringBuilder();
            for (Set<Integer> s : listOfSets) {
                petals.append(s.size() - cKerner).append(" ");
            }

            System.out.println("YES");
            System.out.println(cKerner);
            System.out.println(petals.toString().trim());
        } else {
            System.out.println("NO");
        }
    }
}
