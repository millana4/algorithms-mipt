package yandex_algorithms.one_linked_list;
import java.util.Scanner;

public class one_linked_list_1 {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class OneLinkedList {
        Node head;
        int size;

        OneLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // Добавить число y после x-го числа (1-based индексация)
        // Если x=0 - сделать число y новым началом списка
        public void addElement(int position, int value) {
            Node newNode = new Node(value);
            
            if (position == 0) {
                // Добавляем в начало (перед первым элементом)
                newNode.next = head;
                head = newNode;
            } else {
                // Находим x-ый узел (позиция position)
                Node current = head;
                for (int i = 1; i < position; i++) { // ищем position-1 раз
                    current = current.next;
                }
                // Вставляем после найденного узла
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }

        // Получить значение на позиции x (1-based индексация)
        public int getElement(int position) {
            Node current = head;
            for (int i = 1; i < position; i++) { // ищем position-1 раз
                current = current.next;
            }
            return current.value;
        }

        // Удалить элемент на позиции x (1-based индексация)
        public void removeElement(int position) {
            if (position == 1) {
                // Удаляем первый элемент
                head = head.next;
            } else {
                // Находим узел перед удаляемым (position-1)
                Node current = head;
                for (int i = 1; i < position - 1; i++) {
                    current = current.next;
                }
                // Пропускаем удаляемый узел
                current.next = current.next.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        scanner.nextLine(); // Считываем перевод строки после числа
        
        OneLinkedList list = new OneLinkedList();

        for (int i = 0; i < q; i++) {
            String request = scanner.nextLine();
            if (request.isEmpty() && i == 0) {
                // Если первая строка пустая, читаем следующую
                request = scanner.nextLine();
            }
            
            String[] parts = request.split(" ");

            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1: // Добавить y после x-го элемента
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    list.addElement(x, y);
                    break;
                
                case 2: // Вывести элемент на позиции x
                    x = Integer.parseInt(parts[1]);
                    System.out.println(list.getElement(x));
                    break;
                
                case 3: // Удалить элемент на позиции x
                    x = Integer.parseInt(parts[1]);
                    list.removeElement(x);
                    break;
            }
        }
        scanner.close();
    }
}