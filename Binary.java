import java.util.Scanner;

public class Binary {
    static int[][] tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int verQuantity = Integer.parseInt(scanner.nextLine().trim());

        tree = new int[verQuantity][3];
        for (int i = 0; i < verQuantity; i++) {
            String nums = scanner.nextLine();
            String[] parts = nums.split(" ");

            for (int j = 0; j < 3; j++) {
                int index = Integer.parseInt(parts[j]);
                tree[i][j] = index;
            };
        };
        scanner.close();

        boolean flag = checkBST(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        System.out.println(flag ? "TRUE" : "FALSE");
    }
    
    private static boolean checkBST(int nodeIndex, int min, int max) {
        if (nodeIndex == -1) return true;
        
        int value = tree[nodeIndex][0];
        if (value <= min || value >= max) return false;
        
        int left = tree[nodeIndex][1];
        int right = tree[nodeIndex][2];
        
        return checkBST(left, min, value) && checkBST(right, value, max);
    }
}
