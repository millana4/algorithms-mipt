package mipt_ck_java.hw_crud.model;
import java.util.Objects;

public class BookLib {
    private Integer id;
    private String title;
    private String author;
    private Integer year;
    private Boolean isAvailable;

    public BookLib() {

    }

    public BookLib(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public BookLib(Integer id, String title, String author, Integer year, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Строковое представление объекта Book
     *
     * Используется для логирования и отладки.
     * Возвращает читаемое представление всех полей объекта.
     *
     * @return строковое представление книги
     */
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // Проверка на ссылочное равенство (быстрая проверка)
        if (this == o) return true;

        // Проверка на null и совместимость типов
        if (o == null || getClass() != o.getClass()) return false;

        // Приведение типа и сравнение полей
        BookLib book = (BookLib) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year) &&
                Objects.equals(isAvailable, book.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year, isAvailable);
    }
}
