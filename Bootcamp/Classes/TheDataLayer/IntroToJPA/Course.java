@Entity
@Table(name = "course")
public class Course {

  @Id
  @Column(name="course_code")
  private String courseCode;

  @Column(name="course_name")
  private String courseName;

  // constructor, getters, and setters omitted for brevity
}
