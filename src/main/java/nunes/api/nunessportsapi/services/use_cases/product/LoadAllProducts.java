package nunes.api.nunessportsapi.services.use_cases.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.repositories.product.ProductRepository;

@Service
@AllArgsConstructor
public class LoadAllProducts {

  private final ProductRepository repository;

  public List<Product> call() {
    return repository.findAll();
  }
}
