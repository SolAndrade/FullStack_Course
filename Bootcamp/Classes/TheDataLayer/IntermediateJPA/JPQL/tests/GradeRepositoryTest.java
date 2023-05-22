package TheDataLayer.IntermediateJPA.JPQL.tests;
@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SectionRepository sectionRepository;

    private List<Course> courses;
    private List<Section> sections;
    private List<Grade> grades;

    @BeforeEach
    void setUp() {

        courses = courseRepository.saveAll(List.of(
                new Course("CS101", "Intro to java"),
                new Course("CS103", "Databases")
        ));

        sections = sectionRepository.saveAll(List.of(
                new Section("CS101-A", "CS101",  (short) 1802, "Balderez"),
                new Section("CS101-B", "CS101",  (short) 1650, "Su"),
                new Section("CS103-A", "CS103",  (short) 1200, "Rojas"),
                new Section("CS103-B", "CS103",  (short) 1208, "Tonno")
        ));

        grades = gradeRepository.saveAll(List.of(
                new Grade("Maya Charlotte", "CS101-A", 98),
                new Grade("James Fields", "CS101-A", 82),
                new Grade("Michael Alcocer", "CS101-B", 65),
                new Grade("Maya Charlotte", "CS103-A", 89),
                new Grade("Tomas Lacroix", "CS101-A", 99),
                new Grade("Sara Bisat", "CS101-A", 87),
                new Grade("James Fields", "CS101-B", 46),
                new Grade("Helena Sepulvida", "CS103-A", 72)
        ));

    }

    @AfterEach
    void tearDown() {
        gradeRepository.deleteAll();
        sectionRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @Test
    void findAverageScoreBySection_ValidData_SectionAndAVG() {
        List<Object[]> result = gradeRepository.findAverageScoreBySection();

        assertEquals(3, result.size());
         assertEquals(55.5, result.get(0)[1]);

    }
}
