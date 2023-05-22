@Entity
public class Spell {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
 
   @Enumerated(EnumType.STRING)
   private Level level;
 
}