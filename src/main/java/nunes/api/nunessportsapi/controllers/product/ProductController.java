package nunes.api.nunessportsapi.controllers.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nunes.api.nunessportsapi.dtos.product.ProductRequestDTO;
import nunes.api.nunessportsapi.dtos.product.ProductResponseDTO;
import nunes.api.nunessportsapi.models.Product;
import nunes.api.nunessportsapi.services.use_cases.product.CreateProduct;
import nunes.api.nunessportsapi.services.use_cases.product.DeleteProduct;
import nunes.api.nunessportsapi.services.use_cases.product.LoadAllProducts;
import nunes.api.nunessportsapi.services.use_cases.product.LoadProduct;
import nunes.api.nunessportsapi.services.use_cases.product.UpdateProduct;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

  private final CreateProduct create;
  private final UpdateProduct update;
  private final DeleteProduct delete;
  private final LoadAllProducts loadAll;
  private final LoadProduct loadProduct;

  @PostMapping("/create")
  public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO) {
    Product product = create.call(productRequestDTO);

    ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);

    return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
  }

  @PutMapping("update/{id}")
  public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
    Product product = update.call(id, productRequestDTO);

    ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);

    return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    delete.call(id);

    return ResponseEntity.status(HttpStatus.OK).body("Product with id " + id + " deleted");
  }

  @GetMapping("/list-product/{code}")
  public ResponseEntity<ProductResponseDTO> listProduct(@PathVariable Long code) {
    Product product = loadProduct.call(code);

    ProductResponseDTO productResponseDTO = new ProductResponseDTO(product);

    return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
  }

  @GetMapping("/list-all")
  public ResponseEntity<List<ProductResponseDTO>> listAllProducts() {
    List<Product> allProducts = loadAll.call();

    List<ProductResponseDTO> productResponseDTOs = allProducts.stream()
        .map(ProductResponseDTO::new)
        .collect(Collectors.toList());

    return ResponseEntity.ok(productResponseDTOs);
  }
}
