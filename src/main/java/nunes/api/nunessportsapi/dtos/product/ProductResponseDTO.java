package nunes.api.nunessportsapi.dtos.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nunes.api.nunessportsapi.models.Product;

@Getter
@NoArgsConstructor
public class ProductResponseDTO {

  private String name;
  private Long code;
  private String description;
  private Double price;

  public ProductResponseDTO(Product product) {
    this.name = product.getName();
    this.code = product.getCode();
    this.description = product.getDescription();
    this.price = product.getPrice();
  }
}
