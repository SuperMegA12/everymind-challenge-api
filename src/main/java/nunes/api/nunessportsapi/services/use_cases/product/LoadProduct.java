package nunes.api.nunessportsapi.services.use_cases.product;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.repositories.product.ProductRepository;

@Service
@AllArgsConstructor
public class LoadProduct {

  private final ProductRepository repository;

   public Product call(Long code) {
    Product product = repository.findByCode(code);

    if (product == null)  throw new RuntimeException("Product with code " + code + " not found");

    return product;
  }
}
