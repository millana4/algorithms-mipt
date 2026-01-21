import java.util.Scanner;

class Car {
    String brand;
    String model;
    int year;
    String colour;
    int weight;

    Car(String brand, String model, int year, String colour, int weight) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.weight = weight;
    }

    public void getInfo() {
        System.out.println("Марка: " + brand + ", Модель: " + model + ", Год выпуска: " + year + ", Цвет кузова: " + colour + ", Масса: " + weight + ".");
    }
}

public class carMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем всю строку и разбиваем на части
        String brand = scanner.nextLine();
        String model = scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();
        String colour = scanner.nextLine();
        int weight = scanner.nextInt();
        scanner.close();
        
        Car car1 = new Car(brand, model, year, colour, weight);
        car1.getInfo();
    }
}