@Entity
public class Section {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name="course_code")
  private Course course;

  private int roomNum;
  private int instructorId;

  //constructor, getters, and setters omitted for brevity
}
