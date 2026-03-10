package mipt_ck_java.hw_transactions;

import java.sql.*;

public class AccountDatabases {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ck_account_db";
        String username = "postgres";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.setAutoCommit(false);
            System.out.println("Connection has started!");

            // ✅ Исправлено: правильное название таблицы и полей
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id SERIAL PRIMARY KEY, " +
                    "owner_name VARCHAR(50) NOT NULL, " +
                    "balance DECIMAL(10, 2) NOT NULL" +
                    ");";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Table 'accounts' created successfully (if not existed)");
            }

            connection.commit();
            System.out.println("Transaction committed!");

        } catch (SQLException e) {
            System.out.println("ERROR! Rolling back");
            e.printStackTrace();
        }
    }
}
