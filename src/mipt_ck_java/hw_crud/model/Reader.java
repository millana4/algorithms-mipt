package mipt_ck_java.hw_crud.model;

import java.util.Objects;

public class Reader {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;


    public Reader() {
        // Пустой конструктор для фреймворков
        // Поля инициализируются значениями по умолчанию
    }

    public Reader(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Reader(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // Проверка на ссылочное равенство (быстрая проверка)
        if (this == o) return true;

        // Проверка на null и совместимость типов
        if (o == null || getClass() != o.getClass()) return false;

        // Приведение типа и сравнение полей
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id) &&
                Objects.equals(firstName, reader.firstName) &&
                Objects.equals(lastName, reader.lastName) &&
                Objects.equals(email, reader.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
