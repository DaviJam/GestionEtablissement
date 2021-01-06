package ensup.service;

import ensup.business.Role;

public interface IService<T> {
    void Create(T entity, Role role);
    void Update(T entity, Role role);
    void Remove (T entity, Role role);
    T Read(int index, Role role);
}
