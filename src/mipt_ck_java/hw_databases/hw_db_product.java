package mipt_ck_java.hw_databases;

import java.sql.*;

public class hw_db_product {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ck_product_first_db";
        String username = "postgres";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.setAutoCommit(false);

            System.out.println("Connection has started!");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                    "id SERIAL PRIMARY KEY, " +
                    "title VARCHAR(50) NOT NULL, " +
                    "price DECIMAL(10, 2) NOT NULL" +
                    ");";

            String insertProduct = "INSERT INTO product (title, price)" +
                    "VALUES" +
                    "('cheese', 500)," +
                    "('milk', 100)," +
                    "('apple', 300)," +
                    "('vommit', 800);";


            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                statement.executeUpdate(insertProduct);
                System.out.println("Transaction is finishing");
            }

            connection.commit();
            System.out.println("Transaction commitid!");

            String productTableReader = "SELECT id, title, price FROM product";

            try (Statement statement = connection.createStatement()) {
                ResultSet productSet = statement.executeQuery(productTableReader);

                while (productSet.next()) {
                    System.out.println("id:" + productSet.getInt("id") + ", " +
                            "title:" + productSet.getString("title") + ", " +
                            "price:" + productSet.getInt("price") + ", ");
                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR! Rolling back");
            e.printStackTrace();
        }
    }
}
