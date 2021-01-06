package ensup.dao;

import ensup.business.Role;

import java.util.List;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface IDao<T> {
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
     */
    void delete(T entity);


}
