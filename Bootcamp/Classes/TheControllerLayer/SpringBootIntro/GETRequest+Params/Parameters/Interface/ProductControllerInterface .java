package TheControllerLayer.SpringBootIntro.GETRequest+Params.Parameters.Controller;

public interface ProductControllerInterface {
    Product getProductById(long productId);
    List<Product> getProductsByCategoryAndDepartment(Optional<String> category, String department);
}
