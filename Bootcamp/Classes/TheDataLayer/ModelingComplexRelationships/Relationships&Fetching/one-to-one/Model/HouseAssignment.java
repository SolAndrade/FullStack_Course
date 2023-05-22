public class HouseAssignment {
    private House house;
    private Wing wing;
    private int assignedBed;
  
    @OneToOne(mappedBy="houseAssignment")
    private Student student;
  }
  