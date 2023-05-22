package TheControllerLayer.Add&Update.POSTReq&Validation.POST;

public class Main {
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
      productRepository.save(product);
    }
        
}
