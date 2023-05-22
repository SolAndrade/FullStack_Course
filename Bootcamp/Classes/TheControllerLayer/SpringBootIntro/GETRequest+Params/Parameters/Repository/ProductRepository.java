package TheControllerLayer.SpringBootIntro.GETRequest+Params.Parameters.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryAndDepartment(Category category, Department department);
    List<Product> findByDepartment(Department department);
}

