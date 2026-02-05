package yandex_algorithms.second_milty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class task5_subset {
    static class Number {
        long value;
        int index;

        Number(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Number> positives = new ArrayList<>();    // > 0
        List<Number> zeros = new ArrayList<>();        // == 0
        List<Number> negatives = new ArrayList<>();    // < 0

        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            Number num = new Number(val, i + 1);

            if (val > 0) {
                positives.add(num);
            } else if (val == 0) {
                zeros.add(num);
            } else { // val < 0
                negatives.add(num);
            }
        }

        // Сортируем отрицательные по модулю (самые большие по модулю первыми)
        Collections.sort(negatives, (a, b) -> Long.compare(Math.abs(b.value), Math.abs(a.value)));

        StringBuilder result = new StringBuilder();

        // СЛУЧАЙ 1: Есть положительные числа
        if (!positives.isEmpty()) {
            // Берём все положительные
            for (Number num : positives) {
                result.append(num.index).append(" ");
            }

            // Берём пары отрицательных (чётное количество самых больших по модулю)
            int negPairs = negatives.size() / 2 * 2;
            for (int i = 0; i < negPairs; i++) {
                result.append(negatives.get(i).index).append(" ");
            }
        }
        // СЛУЧАЙ 2: Нет положительных, есть отрицательные
        else if (!negatives.isEmpty()) {
            // Если можно взять чётное количество отрицательных
            if (negatives.size() >= 2) {
                int takeCount = negatives.size();
                if (takeCount % 2 == 1) {
                    takeCount--; // пропускаем самое маленькое по модулю
                }
                for (int i = 0; i < takeCount; i++) {
                    result.append(negatives.get(i).index).append(" ");
                }
            }
            // Если только одно отрицательное
            else {
                // Лучше взять ноль, если есть
                if (!zeros.isEmpty()) {
                    result.append(zeros.get(0).index);
                } else {
                    result.append(negatives.get(0).index);
                }
            }
        }
        // СЛУЧАЙ 3: Только нули или ничего
        else {
            if (!zeros.isEmpty()) {
                result.append(zeros.get(0).index);
            }
            // Иначе массив пуст (по условию n ≥ 1, так что такого не будет)
        }

        // Если всё ещё пусто (крайний случай)
        if (result.length() == 0 && n > 0) {
            // Берём первый элемент
            result.append("1");
        }

        System.out.println(result.toString().trim());
    }
}