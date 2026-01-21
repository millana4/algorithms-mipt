package yandex_algorithms.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class deque_4_ribbon {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String ribbonString = br.readLine();

        ArrayDeque<Character> rawRibbon = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            char s = ribbonString.charAt(i);
            rawRibbon.addLast(s);
        }

        StringBuilder result = new StringBuilder();

        while (!rawRibbon.isEmpty()) {
            char first = rawRibbon.getFirst();
            char last = rawRibbon.getLast();

            if (first <= last) {
                result.append(first);
                rawRibbon.removeFirst();
            } else {
                result.append(last);
                rawRibbon.removeLast();
            }
        }

        System.out.println(result.toString());
    }
}
