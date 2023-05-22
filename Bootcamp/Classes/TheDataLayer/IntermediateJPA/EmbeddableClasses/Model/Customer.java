@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;
  private String firstName;
  private String lastName;

  @Embedded
  Address currentAddress;

  @AttributeOverrides({
    @AttributeOverride(name="streetAddress",column=@Column(name="perm_street")),
    @AttributeOverride(name="city",column=@Column(name="perm_city")),
    @AttributeOverride(name="postalCode",column=@Column(name="perm_postal"))
  })
  @Embedded
  private Address permanentAddress;

  // constructors, getters, and setters omitted for brevity
}
