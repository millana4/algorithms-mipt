package yandex_algorithms.second_milty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task4_multy4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Инициализируем специальными значениями вне диапазона
        final int MIN_VAL = -20001; // меньше минимального -20000
        final int MAX_VAL = 20001;  // больше максимального 20000

        // 4 положительных (максимальные)
        int[] pos4 = {MIN_VAL, MIN_VAL, MIN_VAL, MIN_VAL};
        int pos4Count = 0;

        // 4 отрицательных (максимальные по модулю = минимальные)
        int[] neg4 = {MAX_VAL, MAX_VAL, MAX_VAL, MAX_VAL};
        int neg4Count = 0;

        // 2 положительных 2 отрицательных (все максимальные по модулю)
        int[] pos2neg2 = {MIN_VAL, MIN_VAL, MAX_VAL, MAX_VAL};
        int pos2Count = 0;
        int neg2Count = 0;

        // 1 положительное 3 отрицательных (положительное максимальное, отрицательные минимальные по модулю)
        int[] pos1neg3 = {MIN_VAL, MAX_VAL, MAX_VAL, MAX_VAL};
        int pos1Count = 0;
        int neg3Count = 0;

        // 1 отрицательное 3 положительных (отрицательное максимальное по модулю, положительные минимальные)
        int[] neg1pos3 = {MAX_VAL, MIN_VAL, MIN_VAL, MIN_VAL};
        int neg1Count = 0;
        int pos3Count = 0;

        boolean haveZero = false;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                haveZero = true;
            } else if (num > 0) {
                // 4 положительных
                pos4Count++;
                if (pos4Count == 1) {
                    pos4[0] = pos4[1] = pos4[2] = pos4[3] = num;
                } else if (num >= pos4[0]) {
                    pos4[3] = pos4[2];
                    pos4[2] = pos4[1];
                    pos4[1] = pos4[0];
                    pos4[0] = num;
                } else if (pos4Count == 2 || num >= pos4[1]) {
                    pos4[3] = pos4[2];
                    pos4[2] = pos4[1];
                    pos4[1] = num;
                } else if (pos4Count == 3 || num >= pos4[2]) {
                    pos4[3] = pos4[2];
                    pos4[2] = num;
                } else if (pos4Count == 4 || num >= pos4[3]) {
                    pos4[3] = num;
                }

                // 2 положительных 2 отрицательных (положительные)
                pos2Count++;
                if (pos2Count == 1) {
                    pos2neg2[0] = pos2neg2[1] = num;
                } else if (num >= pos2neg2[0]) {
                    pos2neg2[1] = pos2neg2[0];
                    pos2neg2[0] = num;
                } else if (pos2Count == 2 || num >= pos2neg2[1]) {
                    pos2neg2[1] = num;
                }

                // 1 положительное 3 отрицательных
                if (++pos1Count == 1 || num >= pos1neg3[0]) {
                    pos1neg3[0] = num;
                }

                // 1 отрицательное 3 положительных
                pos3Count++;
                if (pos3Count == 1) {
                    neg1pos3[1] = neg1pos3[2] = neg1pos3[3] = num;
                } else if (num <= neg1pos3[1]) {
                    neg1pos3[3] = neg1pos3[2];
                    neg1pos3[2] = neg1pos3[1];
                    neg1pos3[1] = num;
                } else if (pos3Count == 2 || num <= neg1pos3[2]) {
                    neg1pos3[3] = neg1pos3[2];
                    neg1pos3[2] = num;
                } else if (pos3Count == 3 || num <= neg1pos3[3]) {
                    neg1pos3[3] = num;
                }

            } else { // num < 0
                // 4 отрицательных (максимальные по модулю = минимальные)
                neg4Count++;
                if (neg4Count == 1) {
                    neg4[0] = neg4[1] = neg4[2] = neg4[3] = num;
                } else if (num <= neg4[0]) {
                    neg4[3] = neg4[2];
                    neg4[2] = neg4[1];
                    neg4[1] = neg4[0];
                    neg4[0] = num;
                } else if (neg4Count == 2 || num <= neg4[1]) {
                    neg4[3] = neg4[2];
                    neg4[2] = neg4[1];
                    neg4[1] = num;
                } else if (neg4Count == 3 || num <= neg4[2]) {
                    neg4[3] = neg4[2];
                    neg4[2] = num;
                } else if (neg4Count == 4 || num <= neg4[3]) {
                    neg4[3] = num;
                }

                // 2 положительных 2 отрицательных (отрицательные)
                neg2Count++;
                if (neg2Count == 1) {
                    pos2neg2[2] = pos2neg2[3] = num;
                } else if (num <= pos2neg2[2]) {
                    pos2neg2[3] = pos2neg2[2];
                    pos2neg2[2] = num;
                } else if (neg2Count == 2 || num <= pos2neg2[3]) {
                    pos2neg2[3] = num;
                }

                // 1 положительное 3 отрицательных
                neg3Count++;
                if (neg3Count == 1) {
                    pos1neg3[1] = pos1neg3[2] = pos1neg3[3] = num;
                } else if (num >= pos1neg3[1]) {
                    pos1neg3[3] = pos1neg3[2];
                    pos1neg3[2] = pos1neg3[1];
                    pos1neg3[1] = num;
                } else if (neg3Count == 2 || num >= pos1neg3[2]) {
                    pos1neg3[3] = pos1neg3[2];
                    pos1neg3[2] = num;
                } else if (neg3Count == 3 || num >= pos1neg3[3]) {
                    pos1neg3[3] = num;
                }

                // 1 отрицательное 3 положительных
                if (++neg1Count == 1 || num <= neg1pos3[0]) {
                    neg1pos3[0] = num;
                }
            }
        }

        long maxProduct = Long.MIN_VALUE;

        // 1. 4 положительных
        if (pos4Count >= 4) {
            long prod = (long) pos4[0] * pos4[1] * pos4[2] * pos4[3];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 2. 4 отрицательных
        if (neg4Count >= 4) {
            long prod = (long) neg4[0] * neg4[1] * neg4[2] * neg4[3];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 3. 2 положительных 2 отрицательных
        if (pos2Count >= 2 && neg2Count >= 2) {
            long prod = (long) pos2neg2[0] * pos2neg2[1] * pos2neg2[2] * pos2neg2[3];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 4. 1 положительное 3 отрицательных
        if (pos1Count >= 1 && neg3Count >= 3) {
            long prod = (long) pos1neg3[0] * pos1neg3[1] * pos1neg3[2] * pos1neg3[3];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 5. 1 отрицательное 3 положительных
        if (neg1Count >= 1 && pos3Count >= 3) {
            long prod = (long) neg1pos3[0] * neg1pos3[1] * neg1pos3[2] * neg1pos3[3];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 6. Если есть ноль
        if (haveZero) {
            maxProduct = Math.max(maxProduct, 0);
        }

        System.out.println(maxProduct);
    }
}
