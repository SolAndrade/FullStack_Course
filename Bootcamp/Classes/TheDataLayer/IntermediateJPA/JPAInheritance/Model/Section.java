@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Section {
    private String id;
    private String courseCode;
    private Integer roomNum;
    private Integer enrolled;
    private String instructor;
    private Integer capacity;
  
    public Section(int capacity){
      setCapacity(capacity);
    }
  
    // other constructors, getters, and setters were omitted for brevity
  }
  