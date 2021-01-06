package ensup.service;


import java.util.List;

public interface IService<T>
{
    T get(int index);
    List<T> getAll();
    int createCourse(T entity);
}
