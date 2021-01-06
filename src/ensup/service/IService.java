package ensup.service;

import ensup.business.Role;
import ensup.business.Student;

import java.util.List;

public interface IService<T> {
    void Delete(T entity);
    T Get(int index);
    List<T> GetAll();
}
