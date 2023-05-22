@Entity
@Table(name="song_table")
public  class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy to use SQL auto_increment
  private Long id; // always using wrapper classes for primitives for nullability

  // column annotation is not strictly necessary
  // the default naming strategy will convert camelCase to snake_case
  @Column(name="song_title")
  private String songTitle;

  @Column(name="album_title")
  private String albumTitle;

  private String artist;

  //constructor, getters, and setters omitted for brevity
}
