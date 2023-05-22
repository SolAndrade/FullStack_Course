@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String firstName;
   private String lastName;
 
   @OneToOne
   @JoinColumn(name = "house_assignment_id")
   private HouseAssignment houseAssignment;
 
   @ManyToMany
   @JoinTable(
     name = "students_casts_spells",
     joinColumns = { @JoinColumn(name = "student_id") },
     inverseJoinColumns = { @JoinColumn(name = "spell_id") }
   )
   private List<Spell> spells;
}