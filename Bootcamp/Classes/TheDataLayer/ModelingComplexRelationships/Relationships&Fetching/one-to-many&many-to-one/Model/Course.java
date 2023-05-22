@Entity
public class Course {

  @Id
  private String courseCode;
  private String courseName;

  @OneToMany(mappedBy="course")
  private Set<Section> sections;

  //constructor, getters, and setters omitted for brevity
}
