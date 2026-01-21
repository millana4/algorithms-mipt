package yandex_algorithms.one_linked_list;
import java.io.*;
import java.util.*;

public class one_linked_list_3_optimised {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] firstPos = new int[100001];
        Arrays.fill(firstPos, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (firstPos[val] == -1) {
                firstPos[val] = i; // запоминаем первое вхождение
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            out.append(firstPos[x]).append('\n');
        }

        System.out.print(out);
    }
}