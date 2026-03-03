package mipt_ck_java.hw_crud.model;

import java.time.LocalDate;
import java.util.Objects;

public class BookLoan {
    private Integer id;
    private Integer bookId;
    private Integer readerId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public BookLoan() {

    }

    public BookLoan(Integer bookId, Integer readerId, LocalDate loanDate) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.loanDate = loanDate;
        // При выдаче дата возврата не установлена (книга еще не возвращена)
        this.returnDate = null;
    }

    public BookLoan(Integer id, Integer bookId, Integer readerId, LocalDate loanDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // Проверка на ссылочное равенство (быстрая проверка)
        if (this == o) return true;

        // Проверка на null и совместимость типов
        if (o == null || getClass() != o.getClass()) return false;

        // Приведение типа и сравнение полей
        BookLoan bookLoan = (BookLoan) o;
        return Objects.equals(id, bookLoan.id) &&
                Objects.equals(bookId, bookLoan.bookId) &&
                Objects.equals(readerId, bookLoan.readerId) &&
                Objects.equals(loanDate, bookLoan.loanDate) &&
                Objects.equals(returnDate, bookLoan.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, readerId, loanDate, returnDate);
    }
}
