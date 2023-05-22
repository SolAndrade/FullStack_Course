@Test
void findAverageScoreBySectionWithCapacityNative_ValidData_SectionAndAVG() {
    List<Object[]> result = gradeRepository.findAverageScoreBySectionWithCapacityNative(80);
    assertEquals("Michael Alcocer", result.get(0)[0]);
    assertEquals(65.0, result.get(0)[1]);
}
