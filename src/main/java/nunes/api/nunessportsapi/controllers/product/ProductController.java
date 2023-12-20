package nunes.api.nunessportsapi.controllers.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.dtos.product.ProductRequestDTO;
import nunes.api.nunessportsapi.dtos.product.ProductResponseDTO;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.services.use_cases.product.CreateProduct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

  private final CreateProduct create;

  @PostMapping("/create")
  public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO) {
    Product product = create.call(productRequestDTO);

    ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);

    return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
  }

}
