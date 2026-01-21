import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

public class personMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем всю строку и разбиваем на части
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        
        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        
        Person person1 = new Person(name, age);
        person1.info();
        
        scanner.close();
    }
}