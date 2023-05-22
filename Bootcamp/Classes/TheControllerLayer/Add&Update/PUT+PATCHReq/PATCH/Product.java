package TheControllerLayer.Add&Update.PUT+PATCHReq.PATCH;

@Entity
@DynamicUpdate
public class Product {
  private long id;

  @NotEmpty(message = "You must supply a product name")
  private String name;

  @Digits(integer = 6, fraction = 2)
  private BigDecimal price;
  private Category category;
  private Department department;
}
