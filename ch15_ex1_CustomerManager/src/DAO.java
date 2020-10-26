import java.util.List;

public interface DAO<T> {
	T get(String code) throws NoSuchCustomerException;

	List<T> getAll();

	boolean add(T t);

	boolean update(T t) throws NoSuchCustomerException;

	boolean delete(T t);
}

// "T" is a placeholder for DAO<Customer>