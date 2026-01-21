import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class files {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("Строка " + i + ": " + line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileWriter fw = new FileWriter("output.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            for (int i = 1; i <= 10; i++) {
                bw.write("Запись " + i);
                bw.newLine(); // Добавляем перевод строки
            }
            bw.write("Файл успешно записан"); // Добавляем финальную строку
            
            System.out.println("Данные успешно записаны в файл output.txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
