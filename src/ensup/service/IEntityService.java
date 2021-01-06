package ensup.service;

public interface IEntityService<T, U> extends IService<T> {
    // Create et Update ici
    void Create(T entity, U role);
    void Update(T entity, U role);
}
