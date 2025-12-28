import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String a = sc.nextLine();
        int y = sc.nextInt();sc.nextLine();
        String t = sc.nextLine();
        int p = sc.nextInt();
        Book b1 = new Book(n,a,y,t,p);
        b1.displayInfo();;
    }
}