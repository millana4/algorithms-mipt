public class Book {
    String title;
    String author;
    int year;
    String genre;
    int pages;
    public Book(String title, String author, int year, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.pages = pages;
    }
public void displayInfo() {
    System.out.println("Название: " + title + ", Автор: " + author +
    ", Год издания: " + year + ", Жанр: " + genre +
    ", Страниц: " + pages + ".");
    }
}