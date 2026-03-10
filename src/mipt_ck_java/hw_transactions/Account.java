package mipt_ck_java.hw_transactions;

public class Account {
    private int id;
    private String ownerName;
    private double balance;

    // Конструктор для создания объекта перед вставкой в БД (без id)
    public Account(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Конструктор для извлечения данных из БД (с id)
    public Account(int id, String ownerName, double balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }
}