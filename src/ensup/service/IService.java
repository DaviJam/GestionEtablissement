package ensup.service;


import ensup.dao.ExceptionDao;

import java.util.List;

/**
 * The interface Service.
 *
 * @param <T> the type parameter
 */
public interface IService<T>
{
    /**
     * list all T of the database.
     *
     * @return list of all T
     */
    List<T> getAll() throws ExceptionDao;

    /**
     * Get an T in the database.
     *
     * @param index index of the T to be get
     * @return the class of type T
     */
    T get(int index) throws ExceptionDao;

    /**
     * Create int.
     *
     * @param entity the entity
     * @return type of result
     */
    default int create(T entity) throws ExceptionDao {
        return 0;
    }

    /**
     * Update int.
     *
     * @param entity the entity
     * @return type of result
     */
    default int update(T entity) throws ExceptionDao {
        return 0;
    }

    /**
     * Delete int.
     *
     * @param entity the entity
     * @return the int
     */
    default int delete(T entity) throws ExceptionDao {
        return 0;
    }

    /**
     * delete an T in the database.
     *
     * @param index index of the T to be deleted
     * @return type of the result
     */
    int delete(int index) throws ExceptionDao;
}
