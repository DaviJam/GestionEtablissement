package ensup.service;

public interface IEntityService<T, U> extends IService<T>
{
    // Create et Update ici
    void create(T entity, U role);
    void update(T entity, U role);
}
