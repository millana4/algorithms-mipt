package yandex_algorithms.first_one_linked_list;
import java.util.Scanner;

public class one_linked_list_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        String[] parts = data.split(" ");
        int n = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);

        int[] array = new int[n];

        String request = scanner.nextLine();
        String[] partsArray = request.split(" ");
        
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(partsArray[i]);
        }

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();

            int index = -1; 

            for (int j = 0; j < array.length; j++) {
                if (array[j] == x) {
                    index = j + 1; 
                    break;
                }
            }
            System.out.println(index); 
        }
        scanner.close();
    }
}