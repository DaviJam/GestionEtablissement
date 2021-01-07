package ensup.service;


import java.util.List;

public interface IService<T>
{
    /**
     * list all T of the database.
     *
     * @return list of all T
     */
    List<T> getAll();
    
	/**
     * Get an T in the database.
     *
     * @param index index of the T to be get
     * @return the class of type T
     */
    T get(int index);
    

    /**
     * @param entity
     * @return type of result
     */
    int create(T entity);
    
    /**
     * @param entity
     * @return type of result
     */
    int update(T entity);
    
    /**
     * delete an T in the database.
     *
     * @param index index of the T to be deleted
     * @return type of the result
     */
    int delete(T entity);
    int delete(int index);
}
