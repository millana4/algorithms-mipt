package mipt_ck_java.hw_crud.dao;

import mipt_ck_java.hw_crud.model.BookLoan;
import java.util.List;

/**
 * Интерфейс BookLoanDAO определяет методы для работы с сущностью BookLoan.
 */
public interface BookLoanDAO {
    /**
     * Добавляет новую выдачу книги.
     * @param bookLoan выдача книги для добавления
     * @return true, если операция успешна
     */
    boolean add(BookLoan bookLoan);

    /**
     * Обновляет информацию о выдаче книги.
     * @param bookLoan выдача книги для обновления
     * @return true, если операция успешна
     */
    boolean update(BookLoan bookLoan);

    /**
     * Удаляет выдачу книги по ID.
     * @param id идентификатор выдачи
     * @return true, если операция успешна
     */
    boolean delete(int id);

    /**
     * Получает выдачу книги по ID.
     * @param id идентификатор выдачи
     * @return объект BookLoan или null, если не найдена
     */
    BookLoan getById(int id);

    /**
     * Получает список всех выдач книг.
     * @return список всех выдач
     */
    List<BookLoan> getAll();

    /**
     * Получает список всех книг, выданных конкретному читателю.
     * @param readerId идентификатор читателя
     * @return список выдач книг для данного читателя
     */
    List<BookLoan> getByReaderId(int readerId);

    /**
     * Выдает книгу читателю (создает запись о выдаче и обновляет статус книги).
     * @param bookId идентификатор книги
     * @param readerId идентификатор читателя
     * @return true, если операция успешна
     */
    boolean loanBook(int bookId, int readerId);

    /**
     * Возвращает книгу (обновляет запись о выдаче и статус книги).
     * @param loanId идентификатор выдачи
     * @return true, если операция успешна
     */
    boolean returnBook(int loanId);
}