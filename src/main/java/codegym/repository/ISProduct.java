package codegym.repository;

import codegym.Model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISProduct extends PagingAndSortingRepository<Product, Long> {
}
