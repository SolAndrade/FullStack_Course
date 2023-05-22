@Test
void findAverageScoreBySectionWithCapacity_ValidData_SectionAndAVG() {
    List<Object[]> result = gradeRepository.findAverageScoreBySectionWithCapacity(2L);
    assertEquals("CS101-B", result.get(0)[0]);
    assertEquals(55.5, result.get(0)[1]);
}
