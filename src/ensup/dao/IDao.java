package ensup.dao;

import ensup.business.Role;

/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface IDao<T> {
    /**
     * Read.
     *
     * @param index the index
     * @return the class of type T
     */
    T Read(int index);

    /**
     * Delete.
     *
     * @param entity the entity
     * @param role   the role
     */
    void Delete(T entity, Role role);
}
