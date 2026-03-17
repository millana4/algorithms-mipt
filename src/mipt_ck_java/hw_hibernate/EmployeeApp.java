package mipt_ck_java.hw_hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class EmployeeApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    listAllEmployees();
                    break;
                case "3":
                    findEmployeeById();
                    break;
                case "4":
                    updateEmployee();
                    break;
                case "5":
                    deleteEmployee();
                    break;
                case "0":
                    System.out.println("До свидания!");
                    HibernateUtil.shutdown();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== УПРАВЛЕНИЕ СОТРУДНИКАМИ ===");
        System.out.println("1. Добавить сотрудника");
        System.out.println("2. Показать всех сотрудников");
        System.out.println("3. Найти сотрудника по ID");
        System.out.println("4. Обновить данные сотрудника");
        System.out.println("5. Удалить сотрудника");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void addEmployee() {
        System.out.println("\n--- Добавление нового сотрудника ---");

        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Введите email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Введите зарплату: ");
        BigDecimal salary = new BigDecimal(scanner.nextLine().trim());

        Employee employee = new Employee(firstName, lastName, email, salary);
        employeeDAO.saveEmployee(employee);
    }

    private static void listAllEmployees() {
        System.out.println("\n--- Список всех сотрудников ---");
        List<Employee> employees = employeeDAO.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("Сотрудников нет.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void findEmployeeById() {
        System.out.println("\n--- Поиск сотрудника по ID ---");
        System.out.print("Введите ID сотрудника: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    private static void updateEmployee() {
        System.out.println("\n--- Обновление данных сотрудника ---");
        System.out.print("Введите ID сотрудника для обновления: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Сотрудник с ID " + id + " не найден.");
            return;
        }

        System.out.println("Текущие данные: " + employee);
        System.out.println("Оставьте поле пустым, если не хотите менять.");

        System.out.print("Новое имя (" + employee.getFirstName() + "): ");
        String firstName = scanner.nextLine().trim();
        if (!firstName.isEmpty()) {
            employee.setFirstName(firstName);
        }

        System.out.print("Новая фамилия (" + employee.getLastName() + "): ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty()) {
            employee.setLastName(lastName);
        }

        System.out.print("Новый email (" + employee.getEmail() + "): ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty()) {
            employee.setEmail(email);
        }

        System.out.print("Новая зарплата (" + employee.getSalary() + "): ");
        String salaryStr = scanner.nextLine().trim();
        if (!salaryStr.isEmpty()) {
            employee.setSalary(new BigDecimal(salaryStr));
        }

        employeeDAO.updateEmployee(employee);
    }

    private static void deleteEmployee() {
        System.out.println("\n--- Удаление сотрудника ---");
        System.out.print("Введите ID сотрудника для удаления: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        employeeDAO.deleteEmployee(id);
    }
}