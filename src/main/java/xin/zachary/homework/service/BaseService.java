package xin.zachary.homework.service;

public interface BaseService<T> {
    boolean save(T entity);
    boolean saveOrUpdate(T entity);
    boolean delete(T entity);
    boolean update(T entity);
}
