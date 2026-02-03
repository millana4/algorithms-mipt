package yandex_algorithms.second_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sum_2_polynomials {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String lineA = br.readLine();
        String[] polA = lineA.split(" ");

        int m = Integer.parseInt(br.readLine());
        String lineB = br.readLine();
        String[] polB = lineB.split(" ");

        int k = Math.max(n, m);
        System.out.println(k);

        for (int i = k; i >= 0; i--) {
            int coefA = 0;
            int coefB = 0;

            // Получаем коэффициент из A, если есть
            int indexA = n - i;
            if (indexA >= 0 && indexA < polA.length) {
                coefA = Integer.parseInt(polA[indexA]);
            }

            // Получаем коэффициент из B, если есть
            int indexB = m - i;
            if (indexB >= 0 && indexB < polB.length) {
                coefB = Integer.parseInt(polB[indexB]);
            }

            System.out.print((coefA + coefB) + " ");
        }
    }
}
