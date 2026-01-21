import java.util.Scanner;

class Cat {
    String name;
    int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("Кличка кота: " + name + ", Возраст: " + age);
    }
}

public class oop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем всю строку и разбиваем на части
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        
        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        scanner.close();
        
        Cat cat1 = new Cat(name, age);
        cat1.getInfo();
    }
}