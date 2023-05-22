package TheControllerLayer.SpringBootIntro.GETRequest+Params.Parameters.Model;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private BigDecimal price;
  @Enumerated(EnumType.STRING)
  private Category category;
  @Enumerated(EnumType.STRING)
  private Department department;

  // constructors, getters, and setters were omitted for brevity.
  @GetMapping("/products/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Product getProductById(@PathVariable(name="id") long productId) {
    return productRepository.findById(productId).get();
  }

  @GetMapping("/products")
  @ResponseStatus(HttpStatus.OK)
  public List<Product> getProductsByCategoryAndDepartment(@RequestParam Optional<String> category, @RequestParam(defaultValue = "clothing") String department) {
          if (category.isPresent()) {
              return productRepository.findByCategoryAndDepartment(Category.valueOf(category.get().toUpperCase()), Department.valueOf(department.toUpperCase()));
          } else {
  
              List<Product> products =  productRepository.findByDepartment(Department.valueOf(department.toUpperCase()));
              return products;
          }
      }
  
}
