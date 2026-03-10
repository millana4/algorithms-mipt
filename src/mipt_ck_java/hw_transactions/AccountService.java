package mipt_ck_java.hw_transactions;


import java.sql.*;

public class AccountService {
    private static final String URL = "jdbc:postgresql://localhost:5432/ck_account_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    // ========== 1. CREATE ACCOUNT ==========
    public void createAccount(Account account) throws SQLException {
        if (account.getBalance() < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }

        String sql = "INSERT INTO accounts (owner_name, balance) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, account.getOwnerName());
            stmt.setDouble(2, account.getBalance());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // ========== 2. TRANSFER MONEY (с транзакцией) ==========
    public void transferMoney(int fromAccountId, int toAccountId, double amount)
            throws SQLException, IllegalArgumentException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше нуля");
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(false);

            try {
                // Проверка баланса отправителя
                double fromBalance = getBalance(connection, fromAccountId);
                if (fromBalance < amount) {
                    throw new IllegalArgumentException("Недостаточно средств");
                }

                // Обновление счетов
                updateBalance(connection, fromAccountId, -amount);
                updateBalance(connection, toAccountId, amount);

                connection.commit();
                System.out.println("Перевод выполнен успешно!");

            } catch (Exception e) {
                connection.rollback();
                throw e;
            }
        }
    }

    // ========== 3. GET ACCOUNT ==========
    public Account getAccount(int id) throws SQLException {
        String sql = "SELECT id, owner_name, balance FROM accounts WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                            rs.getInt("id"),
                            rs.getString("owner_name"),
                            rs.getDouble("balance")
                    );
                }
                return null;
            }
        }
    }

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ==========
    private double getBalance(Connection connection, int accountId) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                }
                throw new SQLException("Счёт не найден: " + accountId);
            }
        }
    }

    private void updateBalance(Connection connection, int accountId, double delta) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, delta);
            stmt.setInt(2, accountId);
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Счёт не найден: " + accountId);
            }
        }
    }
}