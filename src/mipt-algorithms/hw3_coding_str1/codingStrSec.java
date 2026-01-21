import java.util.*;
import java.io.*;

public class codingStrSec {
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
        
        int result = findMaxUniqueSplit(decodedString);
        System.out.println(result);
    }
    
    private static int findMaxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }
    
    private static int dfs(String s, int start, Set<String> used) {
        if (start == s.length()) {
            return 0;
        }
        
        int maxCount = -1;
        
        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            
            if (!used.contains(substr)) {
                used.add(substr);
                int nextCount = dfs(s, end, used);
                if (nextCount != -1) {
                    maxCount = Math.max(maxCount, 1 + nextCount);
                }
                used.remove(substr);
            }
        }
        
        return maxCount;
    }
}