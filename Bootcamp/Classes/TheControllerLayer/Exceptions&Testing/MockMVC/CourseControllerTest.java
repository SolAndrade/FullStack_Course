package TheControllerLayer.Exceptions&Testing.MockMVC;

@SpringBootTest
public class CourseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CourseRepository courseRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Course course = new Course("CS101", "Intro to Java");
        Course course2 = new Course("CS102", "Databases");
        courseRepository.saveAll(List.of(course, course2));
    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    void store_Valid_Created() throws Exception {
        Course course = new Course("CS103", "Another course");
        String body = objectMapper.writeValueAsString(course);
        MvcResult mvcResult = mockMvc.perform(post("/courses")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Another course"));
    }

    @Test
    void getAll_Valid_AllCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Intro to Java"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Databases"));
    }
}

