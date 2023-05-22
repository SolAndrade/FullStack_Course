@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;

  @OneToOne
  @JoinColumn(name="house_assignment_id")
  private HouseAssignment houseAssignment;

  // constructors, getters, and setters omitted for brevity
}
