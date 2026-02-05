package yandex_algorithms.second_milty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class task3_multy_negative {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer nums = new StringTokenizer(br.readLine());

        int[] allPos = {0, 0, 0};
        int[] allNeg = {0, 0, 0};
        int[] onePosTwoNeg = {0, 0, 0};
        int[] oneNegTwoPos = {0, 0, 0};

        int allPosCount = 0;
        int allNegCount = 0;
        int onePosTwoNegPosCount = 0;
        int onePosTwoNegNegCount = 0;
        int oneNegTwoPosPosCount = 0;
        int oneNegTwoPosNegCount = 0;

        boolean haveZero = false;

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(nums.nextToken());

            if (next == 0) {
                haveZero = true;
            } else if (next > 0) {
                // Обновляем allPos (3 максимальных положительных)
                allPosCount++;
                if (allPosCount == 1) {
                    allPos[0] = allPos[1] = allPos[2] = next;
                } else if (next > allPos[0]) {
                    allPos[2] = allPos[1];
                    allPos[1] = allPos[0];
                    allPos[0] = next;
                } else if (allPosCount == 2 || next > allPos[1]) {
                    allPos[2] = allPos[1];
                    allPos[1] = next;
                } else if (allPosCount == 3 || next > allPos[2]) {
                    allPos[2] = next;
                }

                // onePosTwoNeg[0] - максимальное положительное
                if (++onePosTwoNegPosCount == 1 || next > onePosTwoNeg[0]) {
                    onePosTwoNeg[0] = next;
                }

                // oneNegTwoPos[1] и [2] - минимальные положительные
                oneNegTwoPosPosCount++;
                if (oneNegTwoPosPosCount == 1) {
                    oneNegTwoPos[1] = oneNegTwoPos[2] = next;
                } else if (next < oneNegTwoPos[1]) {
                    oneNegTwoPos[2] = oneNegTwoPos[1];
                    oneNegTwoPos[1] = next;
                } else if (oneNegTwoPosPosCount == 2 || next < oneNegTwoPos[2]) {
                    oneNegTwoPos[2] = next;
                }

            } else if (next < 0) {
                // Обновляем allNeg (3 максимальных отрицательных - ближайшие к нулю)
                allNegCount++;
                if (allNegCount == 1) {
                    allNeg[0] = allNeg[1] = allNeg[2] = next;
                } else if (next > allNeg[0]) {
                    allNeg[2] = allNeg[1];
                    allNeg[1] = allNeg[0];
                    allNeg[0] = next;
                } else if (allNegCount == 2 || next > allNeg[1]) {
                    allNeg[2] = allNeg[1];
                    allNeg[1] = next;
                } else if (allNegCount == 3 || next > allNeg[2]) {
                    allNeg[2] = next;
                }

                // onePosTwoNeg[1] и [2] - минимальные отрицательные (по модулю максимальные)
                onePosTwoNegNegCount++;
                if (onePosTwoNegNegCount == 1) {
                    onePosTwoNeg[1] = onePosTwoNeg[2] = next;
                } else if (next < onePosTwoNeg[1]) {
                    onePosTwoNeg[2] = onePosTwoNeg[1];
                    onePosTwoNeg[1] = next;
                } else if (onePosTwoNegNegCount == 2 || next < onePosTwoNeg[2]) {
                    onePosTwoNeg[2] = next;
                }

                // oneNegTwoPos[0] - минимальное отрицательное (по модулю максимальное)
                if (++oneNegTwoPosNegCount == 1 || next < oneNegTwoPos[0]) {
                    oneNegTwoPos[0] = next;
                }
            }
        }

        // Вычисляем возможные произведения
        long maxProduct = Long.MIN_VALUE;

        // 1. Три положительных
        if (allPosCount >= 3) {
            long prod = (long) allPos[0] * allPos[1] * allPos[2];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 2. Три отрицательных
        if (allNegCount >= 3) {
            long prod = (long) allNeg[0] * allNeg[1] * allNeg[2];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 3. Один положительный, два отрицательных
        if (onePosTwoNegPosCount >= 1 && onePosTwoNegNegCount >= 2) {
            long prod = (long) onePosTwoNeg[0] * onePosTwoNeg[1] * onePosTwoNeg[2];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 4. Один отрицательный, два положительных
        if (oneNegTwoPosNegCount >= 1 && oneNegTwoPosPosCount >= 2) {
            long prod = (long) oneNegTwoPos[0] * oneNegTwoPos[1] * oneNegTwoPos[2];
            maxProduct = Math.max(maxProduct, prod);
        }

        // 5. Если есть ноль
        if (haveZero) {
            maxProduct = Math.max(maxProduct, 0);
        }

        System.out.println(maxProduct);
    }
}