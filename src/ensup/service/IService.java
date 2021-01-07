package ensup.service;


import java.util.List;

public interface IService<T>
{
    T get(int index);
    List<T> getAll();
    int delete(int index);
}
