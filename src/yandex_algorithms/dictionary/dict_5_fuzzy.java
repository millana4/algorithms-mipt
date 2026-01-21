package yandex_algorithms.dictionary;
import java.util.*;

public class dict_5_fuzzy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> freq = new HashMap<>();
        
        // Считываем слова и считаем их частоты
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        long result = 0;
        List<String> words = new ArrayList<>(freq.keySet());
        int m = words.size();
        
        // Сравниваем каждую пару уникальных слов
        for (int i = 0; i < m; i++) {
            String a = words.get(i);
            int cntA = freq.get(a);
            
            for (int j = i + 1; j < m; j++) {
                String b = words.get(j);
                
                // Проверяем, отличаются ли слова ровно в одной позиции
                int diff = 0;
                for (int k = 0; k < a.length(); k++) {
                    if (a.charAt(k) != b.charAt(k)) {
                        diff++;
                        if (diff > 1) break;
                    }
                }
                
                // Если отличаются ровно в одной позиции, учитываем произведения частот
                if (diff == 1) {
                    result += (long) cntA * freq.get(b);
                }
            }
        }
        
        System.out.println(result);
    }
}