package TheControllerLayer.Add&Update.PUT+PATCHReq.PATCH;

public class ProductPriceOnlyDTO {

    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    public void updatePrice(Long id, BigDecimal price) {
        Product product = productRepository.findById(id).get();
        product.setPrice(price);
        productRepository.save(product);
      }

    @PatchMapping("/products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdatePrice(@PathVariable("id") Long id, @RequestBody ProductPriceOnlyDTO partialProduct) {
    
        productService.updatePrice(id, partialProduct.getPrice());
    }
      
}
  