package nunes.api.nunessportsapi.services.use_cases.product;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.dtos.product.ProductRequestDTO;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.repositories.product.ProductRepository;
import nunes.api.nunessportsapi.services.utils.mapper.EntityMapper;

@Service
@AllArgsConstructor
public class CreateProduct {

  private final ProductRepository repository;

  public Product call(ProductRequestDTO productRequestDTO) {
    Product product = EntityMapper.mapToEntity(productRequestDTO, Product.class);

    return repository.save(product);
  }
}
