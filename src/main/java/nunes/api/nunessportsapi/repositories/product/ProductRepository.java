package nunes.api.nunessportsapi.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nunes.api.nunessportsapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

  Product findByCode(Long code);

}
