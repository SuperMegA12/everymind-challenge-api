package nunes.api.nunessportsapi.services.use_cases.product;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.dtos.product.ProductRequestDTO;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.repositories.product.ProductRepository;

@Service
@AllArgsConstructor
public class UpdateProduct {

  private final ProductRepository repository;

  public Product call(Long id, ProductRequestDTO productRequestDTO) {
    Product productToUpdate = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

    BeanUtils.copyProperties(productRequestDTO, productToUpdate);

    return repository.save(productToUpdate);
  }
}
