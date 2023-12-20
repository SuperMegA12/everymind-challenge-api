package nunes.api.nunessportsapi.services.use_cases.product;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.repositories.product.ProductRepository;

@Service
@AllArgsConstructor
public class DeleteProduct {

  private final ProductRepository repository;

  public void call(Long id) {
    Product product = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

    repository.deleteById(product.getId());
  }
}
