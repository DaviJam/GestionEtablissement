package ensup.service;

import ensup.business.Role;

public interface IService<T> {
    void Remove (T entity);
    T Read(int index);
}
