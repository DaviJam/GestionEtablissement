package ensup.dao;

import java.util.List;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface IDao<T> {

    /**
     * Create.
     *
     * @param entity the entity
     * @return the int
     */
    int create(T entity);

    int createCourse(T entity);

    /**
     * Update.
     *
     * @param entity the entity
     * @return the int
     */
    int update(T entity);

    /**
     * Get.
     *
     * @param index the index
     * @return the class of type T
     */
    T get(int index);

    /**
     * Get all list.
     *
     * @return the list
     */
    List<T> getAll();

    /**
     * delete.
     *
     * @param entity the entity
     * @return the int
     */
    int delete(T entity);
}
