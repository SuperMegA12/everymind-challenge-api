package nunes.api.nunessportsapi.dtos.product;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

  @NotNull
  private String name;

  @NotNull
  private Long code;

  @NotNull
  private String description;

  @NotNull
  private Double price;

}
