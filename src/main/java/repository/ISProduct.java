package repository;

import Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ISProduct extends CrudRepository<Product, Long> {
}
