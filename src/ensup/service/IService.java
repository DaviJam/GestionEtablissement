package ensup.service;


import java.util.List;

public interface IService<T>
{
	/**
     * Get an T in the database.
     *
     * @param index index of the T to be get
     * @return the class of type T
     */
    T get(int index);
    
    /**
     * list all T of the database.
     *
     * @return list of all T
     */
    List<T> getAll();
    
    /**
     * delete an T in the database.
     *
     * @param index index of the T to be deleted
     * @return type of the result
     */
    int delete(int index);
}
