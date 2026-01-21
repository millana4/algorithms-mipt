import java.util.*;
import java.io.*;

public class codingStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Map<String, Character> codes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            char symbol = line.charAt(1);
            String code = line.substring(line.indexOf(',') + 2, line.length() - 1);
            codes.put(code, symbol);
        }
        
        String encoded = br.readLine();
        
        // Декодируем строку
        StringBuilder decoded = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        
        for (char bit : encoded.toCharArray()) {
            currentCode.append(bit);
            if (codes.containsKey(currentCode.toString())) {
                decoded.append(codes.get(currentCode.toString()));
                currentCode.setLength(0);
            }
        }
        
        String decodedString = decoded.toString();
        
        // Жадное разбиение на уникальные подстроки
        Set<String> used = new HashSet<>();
        int count = 0;
        int start = 0;
        
        for (int end = 1; end <= decodedString.length(); end++) {
            String currentSub = decodedString.substring(start, end);
            if (!used.contains(currentSub)) {
                System.out.println(currentSub);
                used.add(currentSub);
                count++;
                start = end;
            }
        }
        
        System.out.println(count);
    }
}