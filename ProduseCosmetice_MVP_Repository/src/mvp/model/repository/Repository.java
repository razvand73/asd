package mvp.model.repository;

import java.util.List;

public interface Repository<T> {

	void add(T t, String fileName);
	void update(T t, String fileName);
	List<T> getAll(String fileName);
	T get(int id, String fileName);
}
