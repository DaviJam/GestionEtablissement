package ensup.service;

import ensup.business.Role;
import ensup.business.Student;

import java.util.List;

public interface IService<T>
{
    void delete(T entity);
    T get(int index);
    List<T> getAll();
}
