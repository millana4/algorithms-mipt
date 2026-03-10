package mipt_ck_java.hw_transactions;

import java.sql.SQLException;
import java.util.Scanner;

public class BankConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountService accountService = new AccountService();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    transferMoney();
                    break;
                case "3":
                    viewAccount();
                    break;
                case "0":
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== БАНКОВСКАЯ СИСТЕМА ===");
        System.out.println("1. Создать новый счёт");
        System.out.println("2. Перевести деньги");
        System.out.println("3. Просмотреть информацию о счёте");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void createAccount() {
        System.out.println("\n--- Создание нового счёта ---");

        System.out.print("Введите имя владельца: ");
        String ownerName = scanner.nextLine().trim();

        System.out.print("Введите начальный баланс: ");
        double balance = Double.parseDouble(scanner.nextLine().trim());

        try {
            Account account = new Account(ownerName, balance);
            accountService.createAccount(account);
            System.out.println("Счёт успешно создан! ID: " + account.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
    }

    private static void transferMoney() {
        System.out.println("\n--- Перевод денег ---");

        try {
            System.out.print("Введите ID счёта-отправителя: ");
            int fromId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите ID счёта-получателя: ");
            int toId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите сумму перевода: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            accountService.transferMoney(fromId, toId, amount);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное число");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
        }
    }

    private static void viewAccount() {
        System.out.println("\n--- Информация о счёте ---");

        try {
            System.out.print("Введите ID счёта: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Account account = accountService.getAccount(id);
            if (account != null) {
                System.out.println("ID: " + account.getId());
                System.out.println("Владелец: " + account.getOwnerName());
                System.out.println("Баланс: " + account.getBalance());
            } else {
                System.out.println("Счёт с ID " + id + " не найден");
            }

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный ID");
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
        }
    }
}