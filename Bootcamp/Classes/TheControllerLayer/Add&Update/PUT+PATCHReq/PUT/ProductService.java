package TheControllerLayer.Add&Update.PUT+PATCHReq.PUT;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        product.setId(productOptional.get().getId());
        productRepository.save(product);
    }
}
