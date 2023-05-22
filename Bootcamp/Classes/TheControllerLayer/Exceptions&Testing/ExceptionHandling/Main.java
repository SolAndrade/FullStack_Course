package TheControllerLayer.Exceptions&Testing.ExceptionHandling;

public class Main {
    @PutMapping("/products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable long id, @RequestBody Product product) {
          productService.update(id, product);
    }
    public void update(long id, Product product){
        Optional<Product> productOptional = productRepo.findById(id);
        product.setId(productOptional.get().getId());
        productRepository.save(product);
    }
    public void update(long id, Product product){
        Product fromRepo = productRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        product.setId(fromRepo.getId());
        productRepository.save(product);
    }
              
}
