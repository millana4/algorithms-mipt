package hw3_strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KMP {

    public static int[] prefix(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            pi[i] = j;
        }
        return pi;
    }

    public static int levenshtein(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new java.io.BufferedInputStream(System.in), "UTF-8");
        String text = sc.nextLine().toLowerCase();
        int k = sc.nextInt();

        // получить только слова с буквами
        List<String> words = new ArrayList<>();
        Matcher m = Pattern.compile("\\p{L}+").matcher(text);
        while (m.find()) words.add(m.group());

        String bestWord = "";
        int maxSum = -1;
        int maxLength = 0;
        int firstOccurrence = Integer.MAX_VALUE;

        Map<String, Integer> firstOccurrences = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!firstOccurrences.containsKey(word)) {
                firstOccurrences.put(word, i);
            }
        }

        for (String w : words) {
            int[] pi = prefix(w);
            int sum = 0;
            for (int x : pi) sum += x;

            if (sum > maxSum ||
               (sum == maxSum && w.length() > maxLength) ||
               (sum == maxSum && w.length() == maxLength && firstOccurrences.get(w) < firstOccurrence)) {
                bestWord = w;
                maxSum = sum;
                maxLength = w.length();
                firstOccurrence = firstOccurrences.get(w);
            }
        }

        Set<String> uniqueWords = new HashSet<>(words);
        int count = 0;
        for (String w : uniqueWords) {
            if (!w.equals(bestWord) && levenshtein(bestWord, w) <= k) {
                count++;
            }
        }

        System.out.println(bestWord);
        System.out.println(maxSum);
        System.out.println(count);
    }
}
