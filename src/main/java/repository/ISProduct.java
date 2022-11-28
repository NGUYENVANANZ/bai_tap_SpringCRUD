package repository;

import Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISProduct extends PagingAndSortingRepository<Product, Long> {
}
