package TheControllerLayer.SpringBootIntro.HTTP+REST.PlayLoad;

public class Main {
    @RequestMapping(value="/products", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
      productRepo.save(product);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable long id) {
      return productRepo.findById(id).get();
    }

}
