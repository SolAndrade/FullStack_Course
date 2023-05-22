package TheControllerLayer.Add&Update.POSTReq&Validation.JakartaValidation.Model;

public class Product {
    private long id;
  
    @NotEmpty(message = "You must supply a product name")
    private String name;
  
    // Validates the maximum number of digits for the integral and fractional parts
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    private Category category;
    private Department department;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody @Valid Product product) {
      productRepository.save(product);
    }
    
}
  