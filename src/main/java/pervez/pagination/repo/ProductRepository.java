package pervez.pagination.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pervez.pagination.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
