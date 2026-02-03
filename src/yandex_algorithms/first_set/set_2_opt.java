package yandex_algorithms.first_set;

import java.io.*;
import java.util.*;

public class set_2_opt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BitSet bitSet = new BitSet(1_000_001);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                bitSet.set(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(bitSet.cardinality());
    }
}