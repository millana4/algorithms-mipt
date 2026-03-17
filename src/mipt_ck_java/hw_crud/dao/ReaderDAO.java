package mipt_ck_java.hw_crud.dao;

import mipt_ck_java.hw_crud.model.Reader;
import java.util.List;

/**
 * Интерфейс ReaderDAO определяет методы для работы с сущностью Reader.
 */
public interface ReaderDAO {
    /**
     * Добавляет нового читателя в базу данных.
     * @param reader читатель для добавления
     * @return true, если операция успешна
     */
    boolean add(Reader reader);

    /**
     * Обновляет информацию о читателе.
     * @param reader читатель для обновления
     * @return true, если операция успешна
     */
    boolean update(Reader reader);

    /**
     * Удаляет читателя по ID.
     * @param id идентификатор читателя
     * @return true, если операция успешна
     */
    boolean delete(int id);

    /**
     * Получает читателя по ID.
     * @param id идентификатор читателя
     * @return объект Reader или null, если не найден
     */
    Reader getById(int id);

    /**
     * Получает список всех читателей.
     * @return список всех читателей
     */
    List<Reader> getAll();
}

