import java.util.ArrayList;
import java.util.Scanner;

public class hw4_backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt(); // вместимость рюкзака
        int n = scanner.nextInt(); // количество слитков
        
        ArrayList<Integer> blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blocks.add(scanner.nextInt());
        }
        scanner.close();

        boolean[] dp = new boolean[W + 1];
        dp[0] = true; // рюкзак весом 0 всегда можно собрать
        
        for (int weight : blocks) {
            for (int w = W; w >= weight; w--) {
                if (dp[w - weight]) {
                    dp[w] = true;
                }
            }
        }
        
        // Ищем максимальный достижимый вес
        int maxWeight = 0;
        for (int w = W; w >= 0; w--) {
            if (dp[w]) {
                maxWeight = w;
                break;
            }
        }
        
        System.out.println(maxWeight);
    }
}
