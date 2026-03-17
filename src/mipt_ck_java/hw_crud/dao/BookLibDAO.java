package mipt_ck_java.hw_crud.dao;

import mipt_ck_java.hw_crud.model.BookLib;

import java.util.List;

/**
 * Интерфейс BookDAO определяет методы для работы с сущностью Book.
 */
public interface BookLibDAO {
    /**
     * Добавляет новую книгу в базу данных.
     * @param book книга для добавления
     * @return true, если операция успешна
     */
    boolean add(BookLib book);

    /**
     * Обновляет информацию о книге.
     * @param book книга для обновления
     * @return true, если операция успешна
     */
    boolean update(BookLib book);

    /**
     * Удаляет книгу по ID.
     * @param id идентификатор книги
     * @return true, если операция успешна
     */
    boolean delete(int id);

    /**
     * Получает книгу по ID.
     * @param id идентификатор книги
     * @return объект Book или null, если не найдена
     */
    BookLib getById(int id);

    /**
     * Получает список всех книг.
     * @return список всех книг
     */
    List<BookLib> getAll();

    /**
     * Получает список всех книг, доступных для выдачи.
     * @return список доступных книг
     */
    List<BookLib> getAvailableBooks();
}
