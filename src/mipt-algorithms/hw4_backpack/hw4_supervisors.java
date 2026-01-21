import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class hw4_supervisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // кол-во отрезков
        
        ArrayList<int[]> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            segments.add(new int[]{start, end});
        }
        scanner.close();

        // Сортируем отрезки по правому концу
        segments.sort(Comparator.comparingInt(seg -> seg[1]));

        ArrayList<Integer> points = new ArrayList<>();
        int lastPoint = -1;
        
        for (int[] seg : segments) {
            if (lastPoint < seg[0]) {
                lastPoint = seg[1];
                points.add(lastPoint);
            }
        }
        
        int supervisors = points.size();  
        System.out.println(supervisors);
    }
}
