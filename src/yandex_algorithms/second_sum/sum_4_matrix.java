package yandex_algorithms.second_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sum_4_matrix {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
        String[] sizeMatrix = size.split(" ");

        int n = Integer.parseInt(sizeMatrix[0]);
        int m = Integer.parseInt(sizeMatrix[1]);

        String[] matrixA = new String[n];
        String[] matrixB = new String[n];

        for (int i = 0; i < n; i++) {
            matrixA[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            matrixB[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer lineA = new StringTokenizer(matrixA[i]);
            StringTokenizer lineB = new StringTokenizer(matrixB[i]);

            StringBuilder row = new StringBuilder();

            for (int j = 0; j < m; j++) {
                int elA = Integer.parseInt(lineA.nextToken());
                int elB = Integer.parseInt((lineB.nextToken()));

                int elC = elA + elB;
                row.append(elC).append(" ");
            }
            System.out.println(row.toString().trim());
        }
    }
}
